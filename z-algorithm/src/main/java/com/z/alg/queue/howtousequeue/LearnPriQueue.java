package com.z.alg.queue.howtousequeue;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * homework: PriorityQueue Learning
 *
 * ordered according to their natural order.
 * or by a Comparator
 *
 *
 *
 * @author zhaoxu
 * @date 11/16/2022 11:09 AM
 * @since
 */
@Slf4j
public class LearnPriQueue {

    public static void main(String[] args) {

        log.info(" impl Comparator");

        // based on priority heap
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        //first based array ,and grows automatically
        // not synchronized

        queue.offer("a");
        queue.offer("bb");
        queue.offer("ccc");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");
        queue.offer("g");


        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }


        log.info("not impl Comparator");





        PriorityQueue<String> queue1 = new PriorityQueue<>();
        //first based array ,and grows automatically
        // not synchronized

        queue1.offer("a");
        queue1.offer("bb");
        queue1.offer("ccc");
        queue1.offer("d");
        queue1.offer("e");
        queue1.offer("f");
        queue1.offer("g");

        while(!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }


    }
}
