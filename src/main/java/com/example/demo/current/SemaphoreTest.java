package com.example.demo.current;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * @author yangkaile
 * @date 2019-06-13 10:18:17
 */
public class SemaphoreTest {
    /**
     * 创建一个Semaphore实例，初始信号量设置为0
     */
    private static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        ExecutorService executorService = new ThreadPoolExecutor(
                size, size, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        Random random = new Random();
        for(int i = 0 ; i < 100 ; i ++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        long time = random.nextInt(1000) + 1;
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName() + "\t sleep:" + time);
                        semaphore.release();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("========= main awaiting ");
        semaphore.acquire(49);
        int count = executorService.shutdownNow().size();
        System.out.println("========= executorService shutdownNow " + count);
        System.exit(0);
    }
}
