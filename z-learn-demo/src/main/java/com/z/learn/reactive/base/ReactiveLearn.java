package com.z.learn.reactive.base;

/**
 * there must be some difficult problem now,
 * cant solved ,
 * so first question,
 *
 * WHICH problem is Reactive programming trying to solve?
 *
 * take a fast food example
 *
 * traditional language,
 * a thread would execute these steps one at a time
 *
 * one waiter
 * one cashier
 *
 * not only waiter is waiting the order
 * but also kitchen is waiting the order
 *
 * that means they are blocked!
 *
 *
 * as for thread, when the thread is waiting for database,
 * they are blocked
 * while you can increase the number of the threads in your
 * thread pool ,you are ultimately limit by the number of cores your
 * platform has
 *
 *
 * in summary,the aime of reactive programming is to help your applicaiton
 * remain responsive under different workloads
 * and in different environment conditions
 *
 *
 * How reactive program execution?
 *
 * combines the principles of async execution
 * and performs it in a specific pattern which we would define and control
 * through "RP"
 *
 * just like blocking io and nio
 *
 *
 * in the fastfood store example,
 * when the waiter(a thread )
 * give the order to the kitchen,
 * instead of waiting the order,it will inform the customer,
 *
 *
 * thats biggest difference betweeen tradtional syn execution
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @author zhaoxu
 * @since
 *
 * @date 11/15/2022 10:42 AM
 */
public interface ReactiveLearn {


}
