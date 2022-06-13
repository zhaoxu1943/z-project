package juc.threadsafe.plus;

public class ThreadUnSafeExample {

    private int count = 0;

    public void add(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
