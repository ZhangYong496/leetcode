package com.multiThread.demo.test02;

public class Demo01 {
    public static void main(String[] args) {

        SendGifts sendGifts = new SendGifts();

        Thread t1 = new Thread(sendGifts, "同学A");
        Thread t2 = new Thread(sendGifts, "同学B");
        t1.start();
        t2.start();


    }
}
