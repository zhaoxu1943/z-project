package com.z.maj.core;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MajPlayerResult implements Comparable<MajPlayerResult> {


    private Integer scoreSum;

    private BigDecimal percent;

    private BigDecimal money;

    private BigDecimal changeMoney;

    private String nickName;

    private Integer rank;

    private boolean isWin;

    @Override
    public int compareTo(MajPlayerResult o) {
        return o.scoreSum-this.scoreSum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("第").append(rank).append("名:").append(nickName)
                .append(isWin?"赢钱":"输钱")
                .append(changeMoney)
                .append("元");
        return sb.toString();
    }
}
