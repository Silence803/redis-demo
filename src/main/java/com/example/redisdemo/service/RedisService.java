package com.example.redisdemo.service;

import java.util.List;

/**
 * Creat by ZhangXueRong on 2019/12/5
 */
public interface RedisService {

    String set(String key, String value, String nxxx, String expx, int time);

    Object eval(String script, List<String> keys, List<String> args);

}
