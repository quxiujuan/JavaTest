package com.exercise;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadTest {
    @Test
    public void testThreadFixed() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
    }

    @Test
    public void testThreadCached() {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    @Test
    public void testThreadPoolExecutor() {

        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.DAYS, queue);

        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("thread %d finished", this.hashCode()));
                }
            });
        }
        executor.shutdown();
    }
}
