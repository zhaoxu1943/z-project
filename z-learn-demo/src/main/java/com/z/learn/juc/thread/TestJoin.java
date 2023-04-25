package com.z.learn.juc.thread;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

public class TestJoin {

    /**
     * @author zhaoxu
     */
    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                Thread.sleep(5000);
                System.out.println("t1");
            }
        });
         t1.start();
         //t1.join()调用者为main线程,
        //结果等待thread1执行结束后main线程才继续执行
        // 所以main线程会等待t1线程执行完毕后再执行
         t1.join();
         //t1
        //main 线程执行完毕


//        t1.join();
        //main 线程执行完毕
        //t1


         System.out.println("main 线程执行完毕");
    }

}
