package com.leetcode.demo.topic02;

/**
 * @author alexzhang
 */
public class AddTwoNumbers {

    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    /**
     * 问题：简单来说就是需要使用链表存储数据，并且是逆序存储，默认不以数据0作为开头，每个节点只能存储一个数字，求和
     * 思路：1、两个链表不能都为null, 如果链表1为null,返回链表2，反之返回链表1
     * 2、因为存储顺序是逆序，也就是第一位是个位数，第二位是十位数，依次递增，计算的时候从第一位开始累加，
     * 3、将累加数据进行取模 mod操作 得到当前位的值，
     * 4、将累加数据进行整除 作为是否存在进一的依据
     * 5、每次做完操作指针后移，查看是否存在后续操作
     * <p>
     * 注意： 容易理解错误的点是 l1，l2是指向节点的指针不是节点本身
     *
     * @param l1 节点1
     * @param l2 节点2
     * @return 返回一个存储结果的链表
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int additional = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + additional;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            additional = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (additional > 0) {
            tail.next = new ListNode(additional);
        }
        return head;
    }


    public ListNode version2(ListNode l1, ListNode l2) {
        ListNode current = null, res = null;
        int additional = 0;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + additional;
            //第一位数进行相加
            if (res == null) {
                res = new ListNode(sum % 10);
                current = res;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            additional = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (additional > 0) {
            current.next = new ListNode(additional);
        }
        return res;
    }
}
