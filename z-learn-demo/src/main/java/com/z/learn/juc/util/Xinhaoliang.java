package com.z.learn.juc.util;

import java.util.concurrent.Semaphore;

/**
 *
 * Learn Sap
 * @author zhaoxu
 * @date 12/14/2022 2:12 PM
 * @since
 */
public class Xinhaoliang {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release(1);
        semaphore.toString();
    }
}
