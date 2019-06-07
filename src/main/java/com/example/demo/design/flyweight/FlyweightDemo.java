package com.example.demo.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 享元模式以提高系统性能为目的，在系统中大量使用
 * String 字符串常量池
 * Integer 缓存 -128~127之间的Integer对象
 * Long 缓存 -128~127之间的对象
 * Java基本类型的包装类大部分都实现了常量池技术，即：Byte、Short、Integer、Long、Character、Boolean
 *
 * CPG里维护的各个平台推送的连接
 */
public class FlyweightDemo {
    /**
     * 维护一个连接的Map
     */
    private static Map<String,Object> connection = new HashMap<>(16);

    /**
     * 使用时去获取连接，获取不到时才去创建连接
     * @param name
     * @return
     */
    public static Object getConnection(String name){
        Object object = connection.get(name);
        if(object == null){
            object = new Object();
            connection.put(name,object);
        }
        return object;
    }
}
