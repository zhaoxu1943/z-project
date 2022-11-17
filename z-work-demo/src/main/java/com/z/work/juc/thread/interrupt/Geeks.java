package com.z.work.juc.thread.interrupt;

import com.z.common.entity.Student;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxu
 * @date 11/17/2022 3:29 PM
 * @since
 */
// Java Program to illustrate the
// concept of interrupt() method
// while a thread stops working

@Slf4j
class Geeks extends Thread {
    public void run() {

            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    log.error("循环体发生中断!");
                    Thread.currentThread().interrupt();
                }

                //逻辑体
                try {
                    Student s = null;
                    s.setId("123");
                }catch(Exception e) {
                    log.error("逻辑错误",e);
                }

        }

    }
    public static void main(String[] args)
    {
        Geeks t1 = new Geeks();

        try {
            t1.start();
            Thread.sleep(3000);
            t1.interrupt();
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }
}