package com.multiThread.demo.test02;

/**
 * @author Alex Zhang
 * @date 2024-03-17
 */
public class SendGifts implements Runnable {

    /**
     * 1、 定义礼品总数量和剩余礼品数量 因为此时使用的是implements Runnable接口，所以是共享一个变量，无需static修饰变量
     * 2、 实现Runnable接口的run方法
     * <p>
     * 多线程四步走：
     * 1、写循环
     * 2、同步代码块的实现
     * 3、判断共享数据是否满足条件，如果满足条件如何实现
     * 4、判断共享数据是否满足条件，如果不满足条件如何实现
     */

    int giftTotalNumber = 100;
    int giftLeftNumber = 10;

    @Override
    public void run() {
        while (true) {
            synchronized (SendGifts.class){
                if(giftTotalNumber==giftLeftNumber){
                    break;
                }else {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    giftTotalNumber --;
                    System.out.println(Thread.currentThread().getName()+"送出一份礼物，还剩余"+giftTotalNumber+"份礼物！");
                }
            }
        }
    }
}
