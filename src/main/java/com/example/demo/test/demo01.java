package com.example.demo.test;

public class demo01 {
    // 写一个递归算法计算1+2+3+...+100
    int function(int n) {
        //终止条件
        if (n == 1)
            return 1;
        //递归调用
        int res = function(n - 1);
        //逐级返回
        return n + res;

    }


    //给定一个斐波那契数列 0、1、1、2、3、5、8 ，求该数列的第 n个数字。
    //递归最重要的三个因子分别是：
    // 1、 终止条件
    // 2、 递归调用 (递归调用原始function的时候一定是靠近终止条件 直到终止条件成立)
    // 3、 结果返回 将每层的结果逐级返回到上一层
   static int fib(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(8));
    }
}
