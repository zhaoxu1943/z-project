package com.z.learn.base;

import lombok.extern.slf4j.Slf4j;

/**
 * what if ; switch without break?
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
@Slf4j
public class TestBreak {


    public static void main(String[] args) {
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }

        log.info("添加break后");

        int d = 1;
        switch (d) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
                break;
        }

    }
}
