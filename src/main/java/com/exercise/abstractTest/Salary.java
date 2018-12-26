package com.exercise.abstractTest;

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


}
