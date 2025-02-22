package test.practicedemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo  extends Thread{
    private Thread thread;
    private String tName;

    ThreadDemo(){

    }

    public ThreadDemo(String tName){
        HashSet<Object> objects = new HashSet<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null,null);
        LinkedList<Object> list = new LinkedList<>();
        LinkedHashSet<Object> objects2 = new LinkedHashSet<>();
        objects2.add(null);
        TreeSet<Object> objects3 = new TreeSet<>();
        objects2.add(1);
        objects2.add(2);
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();
        objects1.add(1);
        CopyOnWriteArraySet<Object> objects4 = new CopyOnWriteArraySet<>();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put(null,null);
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put(null,1);
        objects4.add(1);
        this.tName = tName;
        System.out.println("线程"+tName+"创建");
    }

    public void run(){
        System.out.println("运行"+tName);
        for (int i = 5;i>0;i--){
            System.out.println("线程"+tName+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("线程"+tName+"中断");
            }
            System.out.println("线程"+tName+"退出");
        }
    }

    public void start(){
        System.out.println("线程"+tName+"启动");
        if(thread == null){
            thread = new Thread(this,tName);
            thread.start();
        }
    }
}
