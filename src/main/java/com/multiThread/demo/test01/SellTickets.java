package com.multiThread.demo.test01;

/**
 * @author Alex Zhang
 * @date 2024-03-17
 */

public class SellTickets extends Thread {

    /**
     * 1、定义一共可以卖多少张票
     * 因为多线程是通过继承thread类实现，所以需要new多个对象，为了保证卖票的总数是一致的，需要使用static修饰变量，保证线程间使用同一个变量
     * 2、实现run方法
     * 通过锁的方式实现多个线程同时卖票
     * <p>
     * <p>
     * 多线程四步走：
     * 1. 写循环
     * 2. 同步代码块
     * 3. 判断共享数据是否满足条件 如果满足条件
     * 4. 判断共享数据是否满足条件 如果不满足条件
     */


    //定义总共多少张票
    static int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (SellTickets.class) {
                //如果票不够，直接结束
                if (ticket == 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(300);
                        ticket--;
                        System.out.println(getName() + "卖了一张票,    还剩余" + ticket + "张票！！！");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }
}
