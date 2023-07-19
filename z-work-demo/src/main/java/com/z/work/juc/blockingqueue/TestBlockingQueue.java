package com.z.work.juc.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
public class TestBlockingQueue {

    public static void main(String[] args) {


        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(2);



        try {
            blockingDeque.put("1");
            log.info("put-1");
            blockingDeque.put("2");
            log.info("put-2");



            String take1 = blockingDeque.take();
            log.info("take:{}", take1);
            String take2 = blockingDeque.take();
            log.info("take:{}", take2);


            blockingDeque.put("3");
            log.info("put-3");
            blockingDeque.put("4");
            log.info("put-4");
            blockingDeque.put("5");
            log.info("put-5");
            blockingDeque.put("6");
            log.info("put-6");
            blockingDeque.put("7");
            log.info("put-7");
            blockingDeque.put("8");
            log.info("put-8");
            blockingDeque.put("9");
            log.info("put-9");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
