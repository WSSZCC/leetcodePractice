package test.practice;

import java.util.concurrent.locks.Lock;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                System.out.println("我要开始等待1");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("我要被叫醒了1");
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("我要被唤醒2");
                lock.notify();
                System.out.println("我已经被叫醒了2");
            }
        }).start();
    }
}
