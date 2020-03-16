package com.example.redisdemo.utils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Creat by ZhangXueRong on 2019/12/9
 */
public class ReentrantLockTest implements Runnable{

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public synchronized void get() {

        reentrantLock.lock();
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();

    }

    public synchronized void set() {
        reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread(test, "thread-" + i).start();
        }
    }

}
