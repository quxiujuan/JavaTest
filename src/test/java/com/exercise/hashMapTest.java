package com.exercise;

import org.junit.Test;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_SG;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class hashMapTest {
    @Test
    public void hashMapTest(){
        Integer a = null;
        HashMap map=new HashMap();
        map.put("name","juan");
        map.put("age",18);
        map.put("name","ren");
        map.put(a,a);
        map.put(a,a);
        System.out.println(map);
    }
    @Test
    public void hashTableTest(){
        Integer a = null;
        Hashtable hashtable=new Hashtable();
        hashtable.put("name","juan");
        hashtable.put("name","ren");
        System.out.println(hashtable);
        hashtable.hashCode();
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
