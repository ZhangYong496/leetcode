package com.multiThread.demo.test02;

public class Send extends Thread {

    static int giftNumber = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Send.class) {
                if (giftNumber == 10) {
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    giftNumber--;
                    System.out.println(getName() + "送出一份礼物*********，还剩余" + giftNumber + "份礼物！");
                }
            }
        }
    }
}
