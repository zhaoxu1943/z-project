package juc.threadsafe.plus;

public class ThreadUnSafeExample {

    private long count = 0;


    private void add10k(){
        int index  = 0;
        while (index <10000) {
            count += 1;
            index++;
        }
    }

    public static long calc() throws InterruptedException {
        final ThreadUnSafeExample obj  = new ThreadUnSafeExample();
        Thread thread1= new Thread(obj::add10k);
        Thread thread2=new Thread(obj::add10k);
        //等待执行结束
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        return obj.count;
    }

  public static void main(String[] args) throws InterruptedException {
            System.out.println(calc());
  }
}
