package com.z.learn.base;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestBreakAndContinue {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        for (Integer i : list) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

        log.info("添加break后");

        for (Integer i : list) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }



    }
}
