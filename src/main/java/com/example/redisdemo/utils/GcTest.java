package com.example.redisdemo.utils;

/**
 * Creat by ZhangXueRong on 2019/12/10
 */
public class GcTest {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        GcTest objA = new GcTest();
        GcTest objB = new GcTest();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;

        System.gc();
    }

}
