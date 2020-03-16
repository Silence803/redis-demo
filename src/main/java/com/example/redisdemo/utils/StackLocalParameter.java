package com.example.redisdemo.utils;

/**
 * Creat by ZhangXueRong on 2019/12/11
 */
public class StackLocalParameter {

    public StackLocalParameter(String name) {}

    public static void testGC(){
        StackLocalParameter s = new StackLocalParameter("sss");
        s = null;
    }
}
