package com.sdxmxy.bookmanage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * i++不保证原子性
 */

class MyData{
    int i=0;
   volatile int number=0;

    public void addTo60(){
        number=60;
    }

    List list=new ArrayList();
    Collection c=new ArrayList<>();
}
public class VolatileDemo {


    public static void main(String[] args) {

    }

    private static void VolatiledTest() {
        //volatile的可见性

        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停一会儿线程
            try { Thread.sleep( 3000 ); } catch (InterruptedException e) { e.printStackTrace(); }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t addTo60 invoked ");
        },"AAA").start();

        while(myData.number == 0)
        {
            // nothing main thread wait......
            // talk is cheap,show me the code
        }

        System.out.println(Thread.currentThread().getName()+"\t over task......");
    }


    //解决volited的不保证原子性
    private static void MyAtomicInteger() {

        AtomicInteger atomicInteger=new AtomicInteger(10);
        for (int j = 1; j <=100; j++) {
            new Thread(()->{
                atomicInteger.getAndIncrement();
            },String.valueOf(j)).start();

        }
        while(Thread.activeCount() > 2)
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+atomicInteger);
    }
}
