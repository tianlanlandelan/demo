package com.example.demo.current;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @author yangkaile
 * @date 2019-06-04 20:27:05
 */
public class ProducterAndConsumer {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition producerCondition = lock.newCondition();
    final static Condition consumerCondition = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 5;

    public static void main(String[] args){
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (true){
                        Thread.sleep(1000L);
                        while (queue.size() == queueSize){
                            System.out.println("Queue full  await");
                            producerCondition.await();
                        }
                        queue.add("ele");
                        System.out.println("queue add");
                        consumerCondition.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (true){
                        Thread.sleep(1000L);
                        while (0 == queue.size()){
                            System.out.println("Queue empty  await");
                            consumerCondition.await();
                        }
                        System.out.println(queue.poll());
                        producerCondition.signalAll();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
