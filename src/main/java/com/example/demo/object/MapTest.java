package com.example.demo.object;

import com.example.demo.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args){

    }
    public static void hashMapTest(){
        Utils.print("hashMapTest");
        Map<String,String> map = new HashMap<>(16);
        map.put("A","123");


        /*
        int tableSizeFor(int cap)方法中设定HashMap的初始容量
        会找到与传入的参数最接近的2的n次幂
        HashMap容量上限是1 << 30
         */
        Utils.print("tableSizeFor");
        int n = 6;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        Utils.print("1",n);

    }

    public static void concurrentHashMapTest(){
        Utils.print("concurrentHashMapTest");
        Map<String,String> map = new ConcurrentHashMap<>(16);


    }
}
