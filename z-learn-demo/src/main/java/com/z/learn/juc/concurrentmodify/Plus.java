package com.z.learn.juc.concurrentmodify;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 本例中,虽然num被volatile标志,修改总是可见的
 * 但即使可见,由于num++的非原子性操作,在并发条件下可能导致中间值被读取,故无法保证结果为times*2
 *
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
@Slf4j
public class Plus {


    private  volatile int num  = 0;

    private static final  int TIMES = 80000;

    public static void main(String[] args) throws InterruptedException {
        //thread.join 方法: 当前线程等待调用join()方法的线程结束后才能继续执行。

        Plus obj = new Plus();


        Thread thread1= new Thread(() -> {

            for (int i = 0; i < TIMES; i++) {
                obj.add();
            }

        });



        Thread thread2= new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                obj.add();
            }

        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        log.info("两个线程各执行{}次num++操作,理论结果为{},最终结果为{}",TIMES,TIMES*2,obj.num);
    }



    private synchronized void add() {
        num++;
    }
}
