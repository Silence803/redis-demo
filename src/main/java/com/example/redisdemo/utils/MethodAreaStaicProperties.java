package com.example.redisdemo.utils;

/**
 * Creat by ZhangXueRong on 2019/12/11
 */
public class MethodAreaStaicProperties {

    public static final MethodAreaStaicProperties m = new MethodAreaStaicProperties("ffff");

    public MethodAreaStaicProperties(String name){}

    public static void testGC(){
        MethodAreaStaicProperties s = new MethodAreaStaicProperties("sss");
        s = null;
    }
}
