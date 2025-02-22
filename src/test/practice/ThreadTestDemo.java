package test.practice;

import test.practicedemo.ThreadDemo;

public class ThreadTestDemo {
    public static void main(String[] args) {
        threadTest();
    }

    private static void threadTest() {
        ThreadDemo t1 = new ThreadDemo("thread-->1");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("thread-->2");
        t2.start();
    }
}
