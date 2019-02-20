package com.sdxmxy.bookmanage;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockTest {
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    Thread thread = Thread.currentThread();
    public void Lock(){
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void unLock(){
       atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest=new SpinLockTest();
        new Thread(() -> {

            spinLockTest.Lock();
            System.out.println(Thread.currentThread().getName()+"come in");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockTest.unLock();

            System.out.println(Thread.currentThread().getName()+"over");
        }, "A").start();
        new Thread(() -> {

            spinLockTest.Lock();
            System.out.println(Thread.currentThread().getName()+"come in");
            spinLockTest.unLock();
            System.out.println(Thread.currentThread().getName()+"over");
        }, "B").start();

    }
}
