package com.z.play;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maj {

    public static double money = 3.5d;

    public static int time = 2;

    public static int person_3 = 3;

    public static int type_3 = 35000;

    public static double sumAll  = type_3*time*person_3;

    public static double moneyAll = money*person_3*time;

    public static String zhengyang = "吃肉的山羊";
    public static String zhanglei = "毒瘤小张";

    public static String zhaoxu = "stephen1943";

    public static String CHANG_CI = "友人塌";

    public static String origin = "友人塌\n" +
            "1位 毒瘤小张\n" +
            "3位 stephen1943\n" +
            "57000\n" +
            "18500\n" +
            "2位 吃肉的山羊\n" +
            "29500\n" +
            "友人塌\n" +
            "1位 stephen1943\n" +
            "3位 吃肉的山羊\n" +
            "704002位 毒瘤小张\n" +
            "-10800\n" +
            "45400";

    public static void main(String[] args) {

        List<String> originResultList = convertStringToList(origin);
        //总的对局map
        List<Map<String,Integer>> resultMapList = Lists.newArrayList();

        for (String originResultString:originResultList){
            if (StrUtil.isNotEmpty(originResultString)){
                resultMapList.add(convertStringToMap(originResultString));
            }
        }
        //计算
        System.out.println("扫描结果:");

        for (Map<String,Integer> map:resultMapList) {
            System.out.println(map);
        }
        System.out.println("执行计算:");

        double sumZhao = getSum(resultMapList,zhaoxu);
        double sumZhang = getSum(resultMapList,zhanglei);
        double sumZheng = getSum(resultMapList,zhengyang);
        System.out.println("stephen1943总分:"+sumZhao+",占比:"+sumZhao/Maj.sumAll*100+"%,钱:"+sumZhao/sumAll*moneyAll+"元");
        System.out.println("毒瘤小张总分:"+sumZhang+",占比:"+sumZhang/Maj.sumAll*100+"%,钱:"+sumZhang/sumAll*moneyAll+"元");
        System.out.println("吃肉的山羊总分:"+sumZheng+",占比:"+sumZheng/Maj.sumAll*100+"%,钱:"+sumZheng/sumAll*moneyAll+"元");

    }


    private static double getSum(List<Map<String,Integer>> resultMapList,String name) {
        double sum = 0;
        for (Map<String,Integer> map:resultMapList) {
            if (map.containsKey(name)) {
                sum += map.get(name);
            }
        }
        return sum;
    }

    /**
     * 将字符串识别为分数Map
     * @param originResultString  每一局的结果
     * @return Map<String,Integer>  key为玩家名字，value为分数
     * @author zhaoxu
     */
    private static Map<String,Integer> convertStringToMap(String originResultString) {
            //首先扫描分数
            //有序的分数list
            List<Integer> sortedScoreList = getSortedScoreList(originResultString);
            //扫描玩家次序,形成Map
            return getPlayerMap(originResultString, sortedScoreList);



    }


    /**
     * 根据原始字符串,分数列表
     * 匹配玩家
     * @param originResultString 原始字符串
     * @param sortedScoreList 有序分数列表
     * @return
     * @throws
     * @author zhaoxu
     */
    private static Map<String,Integer> getPlayerMap(String originResultString, List<Integer> sortedScoreList) {
        Map<String, Integer> scoreMap = Maps.newTreeMap();
        String s = originResultString.trim();

        int indexZhao = s.indexOf("zhaoxu");
        String rankZhao = s.substring(indexZhao - 3, indexZhao - 1);
        int indexZhang = s.indexOf("zhanglei");
        String rankZhang = s.substring(indexZhang - 3, indexZhang - 1);
        int indexZheng = s.indexOf("zhengyang");
        String rankZheng = s.substring(indexZheng - 3, indexZheng - 1);


        if ("一位".equals(rankZhao)) {
            scoreMap.put(zhaoxu, sortedScoreList.get(0));
            if ("二位".equals(rankZhang)) {
                scoreMap.put(zhanglei, sortedScoreList.get(1));
                scoreMap.put(zhengyang, sortedScoreList.get(2));
            }else{
                scoreMap.put(zhengyang, sortedScoreList.get(1));
                scoreMap.put(zhanglei, sortedScoreList.get(2));
            }

        } else if ("一位".equals(rankZhang)) {
            scoreMap.put(zhanglei, sortedScoreList.get(0));
            if ("二位".equals(rankZhao)) {
                scoreMap.put(zhaoxu, sortedScoreList.get(1));
                scoreMap.put(zhengyang, sortedScoreList.get(2));
            }else{
                scoreMap.put(zhengyang, sortedScoreList.get(1));
                scoreMap.put(zhaoxu, sortedScoreList.get(2));
            }
        } else {
            scoreMap.put(zhengyang, sortedScoreList.get(0));
            if ("二位".equals(rankZhao)) {
                scoreMap.put(zhaoxu, sortedScoreList.get(1));
                scoreMap.put(zhanglei, sortedScoreList.get(2));
            }else {
                scoreMap.put(zhanglei, sortedScoreList.get(1));
                scoreMap.put(zhaoxu, sortedScoreList.get(2));
            }
        }
        return scoreMap;
    }

    /**
     * 获取有序分数列表
     * @param originResultString 原始字符串
     * @author zhaoxu
     */
    private static List<Integer> getSortedScoreList(String originResultString) {
        List<Integer> sortedScoreList = Lists.newArrayList();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(originResultString);
        while (matcher.find()) {
            String number = matcher.group();
            Integer score = Integer.valueOf(number);
            sortedScoreList.add(score);
        }
        sortedScoreList.sort((o1, o2) -> o2 - o1);
        return sortedScoreList;
    }


    /**
     * 对字符串做基础处理
     * @param originStr 原始OCR后字符串
     * @return List<String> 每局形成的List
     * @author zhaoxu
     */
    private static List<String> convertStringToList(String originStr) {
        //rename
        String str = originStr.replace("stephen1943", "zhaoxu");
        str = str.replace("吃肉的山羊", "zhengyang");
        str = str.replace("毒瘤小张", "zhanglei");

        //避免分数识别
        str = str.replace("1位", " 一位");
        str = str.replace("2位", " 二位");
        str = str.replace("3位", " 三位");

        return StrUtil.split(str, CHANG_CI);
    }


}



