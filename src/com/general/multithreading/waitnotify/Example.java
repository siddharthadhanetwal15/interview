package com.general.multithreading.waitnotify;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by dhanetwa on 9/13/2018.
 */
public class Example {

    public static void main(String[] args) {
        CommonQueue commonQueue = new CommonQueue(new ArrayBlockingQueue(2));
        Thread pt = new ProducerExecutor(commonQueue);
        pt.start();
        Thread ct = new ConsumerExecutor(commonQueue);
        ct.start();
        try {
            pt.join();
            ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProducerExecutor extends Thread {
    CommonQueue commonQueue;

    ProducerExecutor(CommonQueue queue) {
        this.commonQueue = queue;
    }

    @Override
    public void run() {
        Employee e1 = new Employee(1, "Sid");
        Employee e2 = new Employee(2, "Kevy");
        Employee e3 = new Employee(3, "Atul");
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        synchronized (this) {
            while (true) {
                try {
                    for (Employee employee : employeeList) {
                        while (commonQueue.getSharedQueue().size() == 2) {
                            wait();
                        }
                        System.out.println(commonQueue.getSharedQueue().add(employee));
                        notify();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ConsumerExecutor extends Thread {
    CommonQueue commonQueue;

    ConsumerExecutor(CommonQueue queue) {
        this.commonQueue = queue;
    }

    //Consumer consumerThread = new Consumer();
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    while (commonQueue.getSharedQueue().isEmpty()) {
                        wait();
                    }
                    System.out.println(commonQueue.getSharedQueue().remove());
                    notify();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class CommonQueue {
    private Queue<Employee> sharedQueue;

    CommonQueue(Queue queue) {
        this.sharedQueue = queue;
    }

    public Queue<Employee> getSharedQueue() {
        return sharedQueue;
    }

    public void setSharedQueue(Queue<Employee> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
}

class Employee {
    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}