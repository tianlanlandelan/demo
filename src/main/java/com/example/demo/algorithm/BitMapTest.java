package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class BitMapTest {
    public static void main(String[] args){
        get();

    }

    /**
     * 有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来
     * 占用约22MB存储空间，时间复杂度和空间复杂度均为O(N)
     */
    public static void get(){
        int count = 10000000;
        int max   = 100000000;
        Random random=new Random();

        BitSet randomSet = new BitSet(max);
        for(int i=0;i<count;i++)
        {
            randomSet.set(random.nextInt(max));
        }

        BitSet bitSet=new BitSet(max);
        bitSet.set(0,max);

        bitSet.xor(randomSet);

        System.out.println("随机数：");
        for(int i=0;i < max ; i++)
        {
            if(randomSet.get(i)){
                System.out.println(i);
            }
        }
        System.out.println("没出现的数：");
        for(int i=0;i < max ; i++)
        {
            if(bitSet.get(i)){
                System.out.println(i);
            }
        }
    }

}
