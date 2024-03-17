package com.multiThread.demo.test02;

public class Demo02 {
    public static void main(String[] args) {

        Send s1 = new Send();
        Send s2 = new Send();
        s1.setName("StudentA");
        s2.setName("StudentB");
        s2.setPriority(1);
        s1.setPriority(10);
        s1.start();
        s2.start();

    }
}
