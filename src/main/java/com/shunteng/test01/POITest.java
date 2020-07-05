package com.shunteng.test01;

import com.shunteng.annotation.MethodOrder;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 测试excel写入
 * @Author GCL
 * @Date 2020/7/2 下午1:54
 */
public class POITest {

    private static String findDateFromDocument(DocumentInputDto documentInputDto) {
        if (documentInputDto.getDateSecond().isEmpty()) {
            return documentInputDto.getDateFirst();
        } else if (documentInputDto.getDateThird().isEmpty()) {
            return documentInputDto.getDateSecond();
        } else if (documentInputDto.getDateFourth().isEmpty()) {
            return documentInputDto.getDateThird();
        } else if (documentInputDto.getDataFifth().isEmpty()) {
            return documentInputDto.getDateFourth();
        } else {
            return "";
        }

    }

    //可优化点：类型判断之后再获取值 尤其是日期类型及richValue
    //row 从0开始 column从1开始
    public static void main(String[] args) throws Exception {
        ExcelUtil source = new ExcelUtil("BD", "C:\\Users\\Guo\\Desktop\\source.xlsm");
        List<DocumentInputDto> listSourceDto = source.readExcelToEntity(DocumentInputDto.class, 2, 820, 9, 51, 53, 55, 57, 59);
        ExcelUtil target = new ExcelUtil("设计文件翻译提交批复状态表", "C:\\Users\\Guo\\Desktop\\target.xlsx");
        List<DataExport> listTargetDto = target.readExcelToEntity(DataExport.class, 5, 434, 5);
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < listTargetDto.size(); i++) {
            DataExport dataExport = listTargetDto.get(i);
            for (int j = 0; j < listSourceDto.size(); j++) {
                DocumentInputDto documentInputDto = listSourceDto.get(j);
                if (dataExport.getData().equals(documentInputDto.getDocument())) {
                    listString.add(findDateFromDocument(documentInputDto));
                    break;
                }
                if (j == listSourceDto.size() - 1) {
                    listString.add("");
                }
            }
        }
        target.writeExcelFromList(listString,"F://date.xlsx");
    }
}

class ExcelUtil {

    private XSSFSheet readXssfSheet;

    private XSSFSheet writeXssfSheet;

    public ExcelUtil(String sheetName, String pathName) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathName);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            XSSFWorkbook sheets = new XSSFWorkbook(bufferedInputStream);
            readXssfSheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取row行，column列的数据
     */
    public String getExcelDateByIndex(int row, int column) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        XSSFCell cell = readXssfSheet.getRow(row).getCell(column);
        if (null != cell) {
            if (cell.getCellType() == 0 && HSSFDateUtil.isCellDateFormatted(cell)) {
                return dateFormat.format(cell.getDateCellValue());
            }
            return cell.getRichStringCellValue().getString();
        }
        return null;
    }

    /**
     * @param clazz    实体类
     * @param rowStart 行开始位置
     * @param rowEnd   行结束位置
     * @param columns  需要哪些列 需要与实体类属性个数对应
     * @Description: 将excel表格中的数据读取到entity实体类中
     */
    public <T> List<T> readExcelToEntity(Class<T> clazz, int rowStart, int rowEnd, int... columns) throws Exception {
        List<T> listT = new ArrayList<>();
        Method method = null;
        String cellValue = null;
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> listMethod = Arrays.stream(methods).filter(method1 -> method1.isAnnotationPresent(MethodOrder.class))
                .sorted(Comparator.comparing(method2 -> method2.getAnnotation(MethodOrder.class).value()))
                .collect(Collectors.toList());
        for (int i = rowStart - 1; i < rowEnd; i++) {
            T instance = clazz.newInstance();
            for (int j = 0; j < columns.length; j++) {
                cellValue = getExcelDateByIndex(i, columns[j] - 1);
                method = listMethod.get(j);
                method.setAccessible(true);
                method.invoke(instance, cellValue);
            }
            listT.add(instance);
        }
        return listT;
    }

    /**
     * @param rowStart 行开始位置
     * @param rowEnd   行结束位置
     * @param column   获取哪些列数据
     * @Description: 获取指定列数据
     */
    public List<List<String>> readExcelToMap(int rowStart, int rowEnd, int... column) {
        List<List<String>> list = new ArrayList<>(rowEnd - rowStart + 1);
        for (int i = rowStart - 1; i < rowEnd; i++) {
            List<String> listRowData = new ArrayList<>(column.length);
            for (int j = 0; j < column.length; j++) {
                String cellValue = getExcelDateByIndex(i, column[j] - 1);
                listRowData.add(cellValue);
            }
            list.add(listRowData);
        }
        return list;
    }


    /**
     * @param list           需要导出的数据
     * @param exportPathName 文件导出位置
     * @Description: 将列表中的数据导出到excel中
     */
    public void writeExcelFromList(List<String> list, String exportPathName) {
        File file = new File(exportPathName);
        FileOutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        XSSFWorkbook writeWorkBook = null;
        try {
            outputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            writeWorkBook = new XSSFWorkbook();
            writeXssfSheet = writeWorkBook.createSheet();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                writeXssfSheet.createRow(i).createCell(0).setCellValue(str);
            }
            writeWorkBook.write(bufferedOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description: 获取目标excel文件的指定列数据 column:从0开始
     */
    public List<String> listSource(int column) {
        return null;
    }

    public XSSFSheet getXssfSheet() {
        return readXssfSheet;
    }

    public void setXssfSheet(XSSFSheet xssfSheet) {
        this.readXssfSheet = xssfSheet;
    }

    public XSSFSheet getReadXssfSheet() {
        return readXssfSheet;
    }

    public void setReadXssfSheet(XSSFSheet readXssfSheet) {
        this.readXssfSheet = readXssfSheet;
    }

    public XSSFSheet getWriteXssfSheet() {
        return writeXssfSheet;
    }

    public void setWriteXssfSheet(XSSFSheet writeXssfSheet) {
        this.writeXssfSheet = writeXssfSheet;
    }


}

class DocumentInputDto {
    private String document;
    private String dateFirst;
    private String dateSecond;
    private String dateThird;
    private String dateFourth;
    private String dataFifth;

    @MethodOrder(1)
    public void setDocument(String document) {
        this.document = document;
    }

    @MethodOrder(2)
    public void setDateFirst(String dateFirst) {
        this.dateFirst = dateFirst;
    }

    @MethodOrder(3)
    public void setDateSecond(String dateSecond) {
        this.dateSecond = dateSecond;
    }

    @MethodOrder(4)
    public void setDateThird(String dateThird) {
        this.dateThird = dateThird;
    }

    @MethodOrder(5)
    public void setDateFourth(String dateFourth) {
        this.dateFourth = dateFourth;
    }

    @MethodOrder(6)
    public void setDataFifth(String dataFifth) {
        this.dataFifth = dataFifth;
    }

    public String getDocument() {
        return document;
    }

    public String getDateFirst() {
        return dateFirst;
    }

    public String getDateSecond() {
        return dateSecond;
    }

    public String getDateThird() {
        return dateThird;
    }

    public String getDateFourth() {
        return dateFourth;
    }

    public String getDataFifth() {
        return dataFifth;
    }
}

class DataExport {
    private String data;

    @MethodOrder(1)
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}