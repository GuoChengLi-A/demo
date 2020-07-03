package com.shunteng.test01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/7/1 下午2:27
 */
public class SensitiveWordFilterTest {


    public static void main(String[] args) {
        SensitiveWordMap sensitiveWordMap = SensitiveWordMap.getInstance();
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter(sensitiveWordMap);
        String text = "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三.级.片 深人静的晚上，关上电话静静的发呆着。";
        Set<String> sensitiveWord = sensitiveWordFilter.getSensitiveWord(text, 1);
        System.out.println(sensitiveWord);
        //如何匹配敏感词

    }

}

/**
 * @Description: 设计为单例模式, 初始化敏感词map
 */
class SensitiveWordMap {

    private HashMap<String, Object> sensitiveWordMap;

    public static SensitiveWordMap getInstance() {
        return new SensitiveWordMap();
    }

    private SensitiveWordMap() {
        Set<String> wordSet = readSensitiveWordFromFile("src/sensitiveWord.txt");
        addSensitveWordToHashMap(wordSet);
    }

    //    {五={星={红={旗={isEnd=1}, isEnd=0}, isEnd=0}, isEnd=0}, 中={isEnd=0, 国={isEnd=0, 人={isEnd=1}, 男={isEnd=0, 人={isEnd=1}}}}}
    private void addSensitveWordToHashMap(Set<String> wordSet) {
        sensitiveWordMap = new HashMap<>(wordSet.size());
        Iterator<String> iterator = wordSet.iterator();
        String word = null;
        Map backupMap = null;
        Map<String, String> wordStatusMap = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            backupMap = sensitiveWordMap;
            for (int i = 0; i < word.length(); i++) {
                char charWord = word.charAt(i);
                Object wordMap = backupMap.get(charWord);
                if (wordMap != null) {//如果存在，直接赋值
                    backupMap = (Map) wordMap;
                } else {//不存在，插入
                    wordStatusMap = new HashMap<>();
                    wordStatusMap.put("isEnd", "0");
                    backupMap.put(charWord, wordStatusMap);//{毛={isEnd=0}}->>{毛={isEnd=0,分={isEnd=0}}}
                    backupMap = wordStatusMap;//切换到内部hashmap，类似指针
                }
                if (i == word.length() - 1) {
                    backupMap.put("isEnd", "1");
                }
            }
        }
//        System.out.println(sensitiveWordMap.toString());
    }

    //io读取敏感词
    private Set<String> readSensitiveWordFromFile(String path) {
        Set<String> set = new HashSet<>();
        File file = new File(path);
        InputStreamReader inputStream = null;
        try {
            inputStream = new InputStreamReader(new FileInputStream(file));
            if (file.isFile() && file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(inputStream);
                String word = null;
                while ((word = bufferedReader.readLine()) != null) {
                    set.add(word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public HashMap<String, Object> getSensitiveWordMap() {
        return sensitiveWordMap;
    }

    public void setSensitiveWordMap(HashMap<String, Object> sensitiveWordMap) {
        this.sensitiveWordMap = sensitiveWordMap;
    }
}

/**
 * @Description: 敏感词过滤器
 */
class SensitiveWordFilter {

    private SensitiveWordMap sensitiveWordMap;

    public SensitiveWordFilter(SensitiveWordMap sensitiveWordMap) {
        this.sensitiveWordMap = sensitiveWordMap;
    }

    /**
     * @Description: 判断是否包含敏感词
     */
    public boolean isContaintSensitiveWord(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = this.CheckSensitiveWord(txt, i, matchType); //判断是否包含敏感字符
            if (matchFlag > 0) {    //大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }

    /**
     * @Description: 检测是否为敏感词，返回敏感词长度
     */
    public int CheckSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word = 0;
        Map nowMap = sensitiveWordMap.getSensitiveWordMap();
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);     //获取指定key，beginIndex为入口索引
            if (nowMap != null) {     //存在，则判断是否为最后一个
                matchFlag++;     //找到相应key，匹配标识+1
                if ("1".equals(nowMap.get("isEnd"))) {       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    if (SensitiveWordMatchTypeEnum.MIN_MATCH.getCode() == matchType) {    //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            } else {     //不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {        //长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }

    /**
     * @Description: 获取敏感词，返回set
     */
    public Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordSet = new HashSet<String>();

        for (int i = 0; i < txt.length(); i++) {
            int length = CheckSensitiveWord(txt, i, matchType);    //判断是否包含敏感字符
            if (length > 0) {    //存在,加入list中
                sensitiveWordSet.add(txt.substring(i, i + length));
                i = i + length - 1;    //减1的原因，是因为for会自增
            }
        }

        return sensitiveWordSet;
    }

}

enum SensitiveWordMatchTypeEnum {
    MIN_MATCH("最小匹配", 1),
    MAX_MATCH("最大匹配", 2);

    private String msg;
    private Integer code;

    SensitiveWordMatchTypeEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}