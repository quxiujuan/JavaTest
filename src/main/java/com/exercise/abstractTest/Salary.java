package com.exercise.abstractTest;

import javax.management.Query;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Salary extends Employee {
    private double salary;

    public Salary(String name, String address, int number,double salary) {
        super(name, address, number);
        setSalary(salary);
        System.out.println("Constructing an Salary");
        System.out.println("getSalary=="+getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void mailCheck()
    {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }

    public double abstractComputePay() {
        return 0;
    }
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 6, 1, TimeUnit.DAYS, queue);

        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(1000);
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
    public void  test(){
System.out.println();
    }




}
