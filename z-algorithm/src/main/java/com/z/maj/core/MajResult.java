package com.z.maj.core;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MajResult implements Comparable<MajResult> {


    private Integer scoreSum;

    private BigDecimal percent;

    private BigDecimal money;

    private BigDecimal changeMoney;

    private String nickName;

    private Integer rank;

    private boolean isWin;

    @Override
    public int compareTo(MajResult o) {
        return o.scoreSum-this.scoreSum;
    }

    @Override
    public String toString() {
        return "MajResult{" +
                "scoreSum=" + scoreSum +
                ", percent=" + percent +
                ", money=" + money +
                ", nickName='" + nickName + '\'' +
                ", rank=" + rank +
                ", isWin=" + isWin +
                '}';
    }
}
