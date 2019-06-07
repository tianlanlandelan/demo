package com.example.demo.design.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例模式测试
 */
public class SingleTest {
    public static void main(String[] args){

        ExecutorService threadPool = Executors.newCachedThreadPool();
        long beginTime = System.currentTimeMillis();
        for(int i = 0 ; i < 10 ; i ++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0 ; j < 1000000 ; j ++){
//                        SingleDemo.getInstance();
                        SingleDoubleCheckDemo.getInstance();
                    }
                    System.out.println(System.currentTimeMillis() - beginTime);

                }
            });

        }




    }
}
