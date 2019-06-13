package com.example.demo.current;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 模拟多线程分多个阶段的任务，每个阶段需要所有线程上一个阶段任务全部执行完毕后才能开始的场景
 * 使用CyclicBarrier实现多个子线程间的分段同步
 * 使用CountDownLatch实现多个子线程和主线程间的同步
 * @author yangkaile
 * @date 2019-06-13 09:08:47
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    private static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException{
        int size = 10;
        ExecutorService executorService = new ThreadPoolExecutor(
                size,size,0L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        Random random = new Random();
        for(int i = 0 ; i < size ; i ++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        long time = random.nextInt(1000) + 1;
                        System.out.println(Thread.currentThread().getName() + "\t on step1 sleep:" + time);
                        cyclicBarrier.await();

                        time = random.nextInt(1000) + 1;
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName() + "\t on step2 sleep:" + time);
                        cyclicBarrier.await();

                        time = random.nextInt(1000) + 1;
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName() + "\t on step3 sleep:" + time);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (BrokenBarrierException b){
                        b.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        System.out.println("main countDownLatch await, cyclicBarrier.getNumberWaiting(): "
                + cyclicBarrier.getNumberWaiting());
        countDownLatch.await();
        System.out.println("main executorService shutdown, cyclicBarrier.getNumberWaiting(): "
                + cyclicBarrier.getNumberWaiting());
        executorService.shutdown();
        System.exit(0);
    }
}
