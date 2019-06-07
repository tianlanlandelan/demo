package com.example.demo.object;

import com.example.demo.ClassSourceCode;
import com.example.demo.Utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
    public static void main(String[] args) throws Exception{
        arrayBlockingQueueTest();
    }

    @ClassSourceCode(packageName = "java.util.concurrent",
            extend = "java.util.AbstractBlockingQueue",
            implement = {"java.util.concurrent.BlockingQueue","java.io.Serializable"},
            description = "间接实现Queue接口和Collection接口,读写共享一个ReentrantLock，" +
                    "内部使用Object[] items存储数据，" +
                    "初始化时要指定队列长度，可指定是否使用公平锁（默认不使用）。" +
                    "take()、put(E) 方法会阻塞，可响应中断，会抛出InterruptedException",
            comparableClass = "LinkedBlockingQueue")
    public static void arrayBlockingQueueTest() throws InterruptedException{
        Utils.print("arrayBlockingQueueTest");

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
//        arrayBlockingQueue.add(null);

        new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000L);
                    Utils.print("Thread Offer",arrayBlockingQueue.offer("Thread Offer"));
                }catch (InterruptedException e){
                    Utils.print("InterruptedException",e.getMessage());
                }
            }
        }.start();
        Utils.print("Take");
        arrayBlockingQueue.take();

        arrayBlockingQueue.offer("A");
        arrayBlockingQueue.offer("B");
        Utils.print("第一次Peek",arrayBlockingQueue.peek());
        Utils.print("第二次Peek",arrayBlockingQueue.peek());
        new Thread(){
            @Override
            public void run(){
                try {
                    sleep(10000L);
                    Utils.print("Thread Poll",arrayBlockingQueue.poll());
                }catch (InterruptedException e){
                    Utils.print("InterruptedException",e.getMessage());
                }
            }
        }.start();

        Utils.print("put");
        arrayBlockingQueue.put("C");

        Utils.print("第一次Poll",arrayBlockingQueue.poll());
        Utils.print("第二次Poll",arrayBlockingQueue.poll());
        Utils.print("第三次Poll",arrayBlockingQueue.poll());
    }
    @ClassSourceCode(packageName = "java.util.concurrent",
            extend = "java.util.AbstractBlockingQueue",
            implement = {"java.util.concurrent.BlockingQueue","java.io.Serializable"},
            description = "间接实现Queue接口和Collection接口," +
                    "读写各使用独自的ReentrantLock（takeLock和putLock）," +
                    "初始化时如果不指定队列长度，默认使用Integer.MAX_VALUE，不可指定是否使用公平锁，" +
                    "其他操作和ArrayBlockingQueue一样",
            comparableClass = "ArrayBlockingQueue")
    public static void linkedBlockingQueueTest() throws InterruptedException{
        Utils.print("linkedBlockingQueueTest");
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(16);
    }

}
