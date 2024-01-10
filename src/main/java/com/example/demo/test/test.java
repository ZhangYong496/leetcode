package com.example.demo.test;

public class test {


    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(nums);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }


    public static int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            if (curSum > 0) {
                curSum = num;
            } else {
                curSum = curSum + num;
            }
            if (curSum > maxValue) {
                maxValue = curSum;
            }
        }
        return maxValue;
    }


    public static int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // 初始化全局最大和为负无穷大
        int currentSum = 0; // 初始化当前子数组的最大和为0
        for (int i = 0; i < nums.length; i++) {
            if (currentSum > 0) { // 当前子数组和大于0
                currentSum = nums[i]; // 更新当前子数组和为当前元素值
            } else {
                currentSum += nums[i]; // 将当前元素值加到当前子数组和上
            }
            if (currentSum > maxSum) { // 当前子数组和大于全局最大和
                maxSum = currentSum; // 更新全局最大和为当前子数组和
            }
        }
        return maxSum; // 返回全局最大和作为最大子数组的和
    }


}
