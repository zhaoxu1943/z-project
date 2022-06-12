package practice.juc.threadsafe.plus;


import org.springframework.util.Assert;

public class Main {

    public static void main(String[] args) {

        ThreadUnSafeExample obj = new ThreadUnSafeExample();

        System.out.println(obj.getCount());

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.add();
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.add();
            }
        }).start();

        System.out.println(obj.getCount());

    }
}
