package com.shunteng.test01;

import com.shunteng.annotation.MethodOrder;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 测试excel写入
 * @Author GCL
 * @Date 2020/7/2 下午1:54
 */
public class POITest {

    //读取excel到内存中，需要映射？映射会好处理 只返回带注解的方法
    public static void main(String[] args) throws Exception {
        String pathName = "src/testExcel.xlsx";
        String sheetName = "sheet1";
        ExcelUtil excelUtil = new ExcelUtil(sheetName, pathName);
        List<ExcelInputDto> listExcelInputDto = excelUtil.readExcelToEntity(ExcelInputDto.class);
//        listExcelInputDto.stream().map(ExcelInputDto::toString).forEach(System.out::println);
        List<String> collect = listExcelInputDto.stream().map(ExcelInputDto::getBirthday).collect(Collectors.toList());
        excelUtil.writeExcelFromList(collect, "/home/gcl/output.xlsx");
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
        XSSFRow dataRow = readXssfSheet.getRow(row);
        XSSFCell cellValue = dataRow.getCell(column);
        if (cellValue.toString().trim().contains("-")) {
            return dateFormat.format(cellValue.getDateCellValue());
        }
        return cellValue.toString();
    }

    public void setExcelDataByIndex(int row, int column, String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (str.trim().contains("-")) {
            Date date = dateFormat.parse(str);
            writeXssfSheet.getRow(row).createCell(column).setCellValue(dateFormat.format(date));
        } else {
            writeXssfSheet.getRow(row).createCell(column).setCellValue(str);
        }
    }

    public <T> List<T> readExcelToEntity(Class<T> clazz) throws Exception {
        List<T> listT = new ArrayList<>();
        Method method = null;
        String cellValue = null;
        int firstRowNum = readXssfSheet.getFirstRowNum();
        int lastRowNum = readXssfSheet.getLastRowNum();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> listMethod = Arrays.stream(methods).filter(method1 -> method1.isAnnotationPresent(MethodOrder.class))
                .sorted(Comparator.comparing(method2 -> method2.getAnnotation(MethodOrder.class).value()))
                .collect(Collectors.toList());
        for (int i = firstRowNum + 1; i < lastRowNum + 1; i++) {
            T instance = clazz.newInstance();
            for (int j = 0; j < listMethod.size(); j++) {
                cellValue = getExcelDateByIndex(i, j);
                method = listMethod.get(j);
                method.setAccessible(true);
                method.invoke(instance, cellValue);

            }
            listT.add(instance);
        }
        return listT;
    }

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
                writeXssfSheet.createRow(i);
                String str = list.get(i);
                setExcelDataByIndex(i, 0, str);
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

class ExcelInputDto {

    private String name;
    private String sex;
    private String age;
    private String birthday;

    @MethodOrder(1)
    public void setName(String name) {
        this.name = name;
    }

    @MethodOrder(2)
    public void setSex(String sex) {
        this.sex = sex;
    }

    @MethodOrder(3)
    public void setAge(String age) {
        this.age = age;
    }

    @MethodOrder(4)
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "ExcelInputDto{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}