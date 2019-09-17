package com.exercise.abstractTest;

import javax.management.Query;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);

        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format("thread %d finished", this.hashCode()));
                    System.out.println(String.format("name"+Thread.currentThread().getName()));

                    Iterator<Query> queryIterator=queue.iterator();
                    while (queryIterator.hasNext()){
                        System.out.println(String.format("queue"+queryIterator.next()));
                    }

                }
            });
        }
        executor.shutdown();
    }
}
