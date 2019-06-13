package com.example.demo.current;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 模拟在主线程中有多个子线程，主线程需要等到子线程全部执行完毕后才执行其他任务
 * @author yangkaile
 * @date 2019-06-13 09:07:50
 */
public class CountDownLatchTest {
    private static CountDownLatch  countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException{
        int size = 2;
        ExecutorService executorService = new ThreadPoolExecutor(
                size,size,0L,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for(int i = 0 ; i < 10 ; i ++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        long sleepTime = new Random().nextInt(1000);
                        System.out.println(((ThreadPoolExecutor) executorService).getQueue().size() + "," + sleepTime);

                        Thread.sleep(sleepTime);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                        System.out.println("CountDownLatch:" + countDownLatch.getCount());
                    }
                }
            });
        }
        System.out.println("main is awaiting");
        countDownLatch.await();
        System.out.println("main is over");
        executorService.shutdown();
        System.exit(0);
    }
}
