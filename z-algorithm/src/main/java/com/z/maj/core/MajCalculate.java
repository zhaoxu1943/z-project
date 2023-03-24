package com.z.maj.core;

import cn.hutool.core.text.CharSequenceUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.z.maj.exception.OcrException;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.z.maj.core.MajConfig.*;

public class MajCalculate {


    private MajContext context;


    /**
     * 算钱主程序
     * @param originStr 原始ocr串
     * @author zhaoxu
     */
    public MajContext calculate(String originStr) {
        //初始处理
        String processStr = initProcess(originStr);

        //获取玩家昵称列表,判定麻将种类
        Set<String> playerSet = playerAnalyse(processStr);
        //分割串,解析局数
        List<String> originResultList = convertStringToList(processStr);
        //基于上述信息,初始化上下文
        initMajContext(playerSet,originResultList.size());
        //生成对局信息
        createMatchInfo();
        //进一步将每局解析为map
        List<Map<String, Integer>> resultMapList = convertToMap(originResultList);
        //计算总分,总钱数,如果OCR异常则抛出
        calculateAndValidate(resultMapList);
        //输出结果
        System.out.println(context);
        return context;
    }

    private String initProcess(String originStr) {
        String str = originStr.replace("sldk19","雨神");
        str = str.replace("stephen1943","zhaoxu");
        //避免分数识别
        str = str.replace("1位", " 一位");
        str = str.replace("2位", " 二位");
        str = str.replace("3位", " 三位");
        str = str.replace("4位", " 四位");
        return str;
    }


    /**
     * 原始字符串提取玩家
     * @param originStr 原始字符串
     * @author zhaoxu
     */
    private  Set<String> playerAnalyse(String originStr) {
        List<String> allNickNameList = MajPlayer.haoge.getAllNickName();
        Set<String> matches = new HashSet<>();
        Pattern pattern = Pattern.compile("\\b(" + String.join("|", allNickNameList) + ")\\b");
        Matcher matcher = pattern.matcher(originStr);
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }
        return matches;
    }


    /**
     * 对字符串做基础处理
     * @param originStr 原始OCR后字符串
     * @return List<String> 每局形成的List
     * @author zhaoxu
     */
    private static List<String> convertStringToList(String originStr) {
        if (originStr.contains(CHANG_CI)){
            return spilt(originStr, CHANG_CI);
        }else if (originStr.contains(CHANG_CI_TRAD)) {
            return spilt(originStr, CHANG_CI_TRAD);
        }else {
            throw new OcrException("spilt异常,无友人场或相关字样");
        }

    }

    /**
     *
     * @param originStr 原始OCR后字符串
     * @param spiltStr 分割字符串
     * @author zhaoxu
     */

    private static List<String> spilt(String originStr, String spiltStr) {
        List<String> originList = CharSequenceUtil.splitTrim(originStr, spiltStr);
        List<String> resultList = Lists.newArrayList();
        for (String s : originList) {
            if (CharSequenceUtil.isNotEmpty(s)) {
                resultList.add(s);
            }
        }
        return resultList;
    }


    /**
     * 初始化上下文
     * @param playerSet 玩家集合
     * @author zhaoxu
     */
    private void initMajContext(Set<String> playerSet, int times) {
        context = new MajContext();
        context.setId(UUID.randomUUID().toString());
        context.setPlayerNickNameSet(playerSet);
        context.setType(playerSet.size());
        context.setTime(times);
        if (context.getType()==3) {
            context.setEveryTenThousandScoreRMB(TYPE_3_EVERY_TEN_THOUSAND_SCORE_RMB);
        }else if (context.getType()==4) {
            context.setEveryTenThousandScoreRMB(TYPE_4_EVERY_TEN_THOUSAND_SCORE_RMB);
        }
        context.setCreateTime(LocalDateTime.now());
    }



    /**
     * 输出对局信息
     * @author zhaoxu
     */
    private void createMatchInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("对局信息:");
        stringBuilder.append(context.getType());
        stringBuilder.append("人局,");
        stringBuilder.append("玩家:");
        stringBuilder.append(context.getPlayerNickNameSet());
        stringBuilder.append(",");
        stringBuilder.append("共打了");
        stringBuilder.append(context.getTime());
        stringBuilder.append("圈,");
        stringBuilder.append("每万分");
        stringBuilder.append(context.getEveryTenThousandScoreRMB());
        stringBuilder.append("元,");
        if (context.getType()==3){
            stringBuilder.append("每人交");
            BigDecimal money = context.getEveryTenThousandScoreRMB().multiply(BigDecimal.valueOf(3.50)).multiply(new BigDecimal(context.getTime()));
            stringBuilder.append(money);
            stringBuilder.append("元");
        }else if (context.getType()==4){
            stringBuilder.append("每人交");
            BigDecimal money = context.getEveryTenThousandScoreRMB().multiply(BigDecimal.valueOf(2.50)).multiply(new BigDecimal(context.getTime()));
            stringBuilder.append(money);
            stringBuilder.append("元");
        }
        context.setMatchInfo(stringBuilder.toString());
    }

    /**
     * 算总分,总钱数,如果OCR异常则抛出
     * @param resultMapList  对局Map
     * @throws RuntimeException OCR异常
     * @author zhaoxu
     */
    private void calculateAndValidate(List<Map<String, Integer>> resultMapList) {
        BigDecimal moneyAll = null;
        int sumAll = 0;
        if (context.getType()==3){
            moneyAll = context.getEveryTenThousandScoreRMB()
                      .multiply(new BigDecimal(TYPE_3_SCORE))
                      .multiply(new BigDecimal(context.getTime()))
                      .multiply(BigDecimal.valueOf(0.0001))
                      .multiply(new BigDecimal(context.getType())
                      .setScale(4, RoundingMode.HALF_UP));
            sumAll  = TYPE_3_SCORE*context.getTime()*context.getType();
        }else if (context.getType()==4){
            moneyAll = context.getEveryTenThousandScoreRMB()
                    .multiply(new BigDecimal(TYPE_4_SCORE))
                    .multiply(new BigDecimal(context.getTime()))
                    .multiply(new BigDecimal(context.getType())
                    .multiply(BigDecimal.valueOf(0.0001))
                    .setScale(4, RoundingMode.HALF_UP));
            sumAll  = TYPE_4_SCORE*context.getTime()*context.getType();
        }

        int actuaSum  = 0;
        List<String> matchResultList = Lists.newArrayList();
        for (String player:context.getPlayerNickNameSet()){
            int sum = getSum(resultMapList,player);
            actuaSum+=sum;
            BigDecimal percent = new BigDecimal(sum).divide(new BigDecimal(sumAll),4,RoundingMode.HALF_UP);
            BigDecimal percentNum = percent.multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP);
            BigDecimal money = percent.multiply(moneyAll).setScale(2, RoundingMode.HALF_UP);
            matchResultList.add(player+":总分:"+sum+",占比:"+percentNum+"%,钱:"+money+"元");
        }
        context.setMatchResultList(matchResultList);

        //validate ocr数据
        if (actuaSum!=sumAll){
            throw new OcrException("扫描异常,扫描总分"+(actuaSum)+"不等于总分"+sumAll+"请重新扫描");
        }
    }

    /**
     * 将spilt后的字符串转换为map
     * @param originResultList 每一局stringList转化为MapList
     * @author zhaoxu
     */

    private List<Map<String, Integer>> convertToMap(List<String> originResultList) {
        List<Map<String,Integer>> resultMapList = Lists.newArrayList();
        for (String originResultString: originResultList){
            if (CharSequenceUtil.isNotEmpty(originResultString)){
                resultMapList.add(convertStringToMap(originResultString));
            }
        }
        context.setMatchDetailList(resultMapList);
        return resultMapList;
    }


    /**
     * 将字符串识别为分数Map
     * @param originResultString  每一局的结果
     * @return Map<String,Integer>  key为玩家名字，value为分数
     * @author zhaoxu
     */
    private  Map<String,Integer> convertStringToMap(String originResultString) {
        //首先扫描分数
        //有序的分数list
        List<Integer> sortedScoreList = getSortedScoreList(originResultString);
        //扫描玩家次序,形成Map
        return getPlayerMap(originResultString, sortedScoreList);



    }






    private  int getSum(List<Map<String,Integer>> resultMapList,String name) {
        int sum = 0;
        for (Map<String,Integer> map:resultMapList) {
            if (map.containsKey(name)) {
                sum += map.get(name);
            }
        }
        return sum;
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
     * 根据原始字符串,分数列表
     * 匹配玩家
     * @param originResultString 原始字符串
     * @param sortedScoreList 有序分数列表
     * @return Map<String,Integer> key为玩家名字，value为分数
     * @author zhaoxu
     */
    private  Map<String,Integer> getPlayerMap(String originResultString, List<Integer> sortedScoreList) {
        Map<String, Integer> scoreMap = Maps.newTreeMap();
        String s = originResultString.trim();

        Set<String> nickNameSet =  context.getPlayerNickNameSet();
        HashMap<String, String> rankMap = Maps.newHashMap();
        for (String nickName : nickNameSet) {
            int index = s.indexOf(nickName);
            String rank = s.substring(index - 3, index - 1);
            rankMap.put(rank,nickName);
        }

        for (int i = 0; i < sortedScoreList.size(); i++) {
            String rank;
            switch (i) {
                case 0:
                    rank= "一位";
                break;
                case 1:
                    rank= "二位";
                break;
                case 2:
                    rank= "三位";
                break;
                case 3:
                    rank= "四位";
                break;
                default:
                    rank= "异常";
            }
            String nickName = rankMap.get(rank);
            scoreMap.put(nickName,sortedScoreList.get(i));
        }
        return scoreMap;
    }






}



