package com.multiThread.demo.test01;

/**
 * @author Alex Zhang
 * @date 2024-03-17
 */
public class Demo01 {
    public static void main(String[] args) {

        SellTickets s1 = new SellTickets();
        SellTickets s2 = new SellTickets();

        s1.setName("窗口1");
        s2.setName("窗口2");
        s1.start();
        s2.start();

    }
}
