package com.z.maj.core;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * maj上下文,
 * 初始化对局者
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
@Data
public class MajContext {


    private String id;

    /**
     * 玩家昵称列表
     * @author zhaoxu
     */
    private Set<String> playerNickNameSet;

    /**
     * 玩家排名map
     * @author zhaoxu
     */
    private Map<String,Integer> allScoreMap;

    /**
     * 玩家数,根据上下文判定三麻还是四麻
     * @author zhaoxu
     */
    private int type;

    /**
     * 每万分多少钱
     * @param
     * @return
     * @throws
     * @author zhaoxu
     */
    private BigDecimal everyTenThousandScoreRMB;

    /**
     * 局数
     * @author zhaoxu
     */
    private int time;

    /**
     * 每局点数
     * @author zhaoxu
     */
    private int scoreEveryTime;

    private LocalDateTime createTime;


    //计算后的字段
    private String matchInfo;

    private List<Map<String,Integer>> matchDetailList;

    private List<MajResult> matchResultList;


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchInfo)
                .append("\n分数详情:\n");

        for (Map<String,Integer> map:matchDetailList){
            stringBuilder.append(map)
                    .append("\n");
        }
        stringBuilder.append("对局结果:\n");

        for (MajResult s:matchResultList){
            stringBuilder.append(s)
                    .append("\n");
        }

        return stringBuilder.toString();
    }
}
