package com.z.work.juc.thread.interrupt;

/**
 * @author zhaoxu
 * @date 11/17/2022 3:25 PM
 * @since
 */
class MyClass extends Thread {
    public void run()
    {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread executing");

                // Here current threads goes to sleeping state
                // Another thread gets the chance to execute
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException occur");
        }
    }
}


class Test {
    public static void main(String[] args)
            throws InterruptedException
    {
        //main thread is executing
        MyClass thread = new MyClass();
        thread.start();

        // main thread calls interrupt() method on
        // child thread
        thread.interrupt();

        System.out.println("Main thread execution completes");
    }
}