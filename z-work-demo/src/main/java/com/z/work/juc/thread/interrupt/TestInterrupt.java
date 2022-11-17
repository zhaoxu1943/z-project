package com.z.work.juc.thread.interrupt;

/**
 * 测试中断
 *
 *
 * 几个原则:
 *
 * 1. About InterruptException
 *     * @throws  InterruptedException
 *      *          if any thread has interrupted the current thread. The
 *      *          <i>interrupted status</i> of the current thread is
 *      *          cleared when this exception is thrown.
 *
 *    if (Thread.interrupted())  // Clears interrupted status!
 *        throw new InterruptedException();
 *
 *  即       throws  InterruptedException 这个动作会清除中断标志
 *  所以在捕获时,要 re-interrupt,维护线程的中断标志
 *
 *  2 .interrupt will set the status
 *
 *  interrupt() method: If any thread is in sleeping or waiting for a state then using the interrupt() method, we can interrupt the execution of that thread by showing InterruptedException. A thread that is in the sleeping or waiting state can be interrupted with the help of the interrupt() method of Thread class.
 *
 *
 * @author zhaoxu
 * @date 11/17/2022 3:15 PM
 * @since
 */
public interface TestInterrupt {





}
