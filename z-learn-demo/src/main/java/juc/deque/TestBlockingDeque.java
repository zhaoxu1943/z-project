package juc.deque;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * blockingDeque 相关操作测试类
 * @param
 * @return
 * @throws
 * @author zhaoxu
 */
public class TestBlockingDeque {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(5);

        Set<String> idSet = new HashSet<>();
        idSet.add("11");
        idSet.add("111");
        idSet.add("112");
        idSet.add("113");
        idSet.add("115");

        blockingDeque.addAll(idSet);

    }

}
