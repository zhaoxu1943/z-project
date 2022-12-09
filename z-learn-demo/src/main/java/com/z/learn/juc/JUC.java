package com.z.learn.juc;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * JUC总览: 你别说,这些玩意哥们多多少少都用过
 *
 * Tools: countdownLatch
 *
 * locks : reentrantLock
 *
 * atomic: AtomicInteger
 *
 * Executor: ExecutorService
 *
 * Collections : Queue,deque,COWAList...
 *
 * 即主要四大部分
 *
 * 1. Lock框架和Tools类
 * 2. Collections : 并发集合
 * 3. Atomic : 原子类
 * 4. Executors: 线程池
 *
 *
 *
 * @author zhaoxu
 * @date 12/8/2022 5:15 PM
 * @since
 */
public interface JUC {
    LockSupport getLockSupport();


}
