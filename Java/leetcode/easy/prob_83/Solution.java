package leetcode.easy.prob_83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * easy
 * 83. Remove Duplicates from Sorted List
 * linked list가 주어졌을 때 중복된 element 제거하기
 *
 * Constraints
 * 0 ~ nodes ~ 300
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted is ascending order
 */

public class Solution {

    // public ListNode deleteDuplicates(ListNode head) {
    // ListNode cur = head;
    // ListNode resultHead = cur;
    // ListNode result = resultHead;

    // while (cur != null) {
    // cur = cur.next;
    // if (cur != null && result.val != cur.val) {
    // result.next = cur;
    // result = result.next;
    // }
    // }

    // if (result != null && result.next != null) {
    // result.next = null; // 마지막은 제거
    // }

    // return resultHead;
    // }

    // better
    public ListNode deleteDuplicates(ListNode head) {
        // check if head == null, then return null
        if (head == null) {
            return null;
        }

        int val = head.val;
        ListNode temp = head;

        // while the list exists, traverse it and remove duplicate values.
        while (temp != null && temp.next != null) {
            // if duplicate value is found, remove and continue.
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            } else {
                val = temp.next.val;
            }
            temp = temp.next;
        }

        return head;
    }

    public void printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public ListNode createNodes(ArrayList<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode tail = head;

        for (int i = 1; i < list.size(); i++) {
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head;

        // ex1 [1, 1, 2]
        // ans [1, 2]
        head = sol.createNodes(new ArrayList<>(Arrays.asList(1, 1, 2)));
        sol.printNode(head);
        sol.deleteDuplicates(head);
        sol.printNode(head);

        // ex2 [1, 1, 2, 3, 3]
        // ans [1, 2, 3]
        head = sol.createNodes(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3)));
        sol.printNode(head);
        sol.deleteDuplicates(head);
        sol.printNode(head);
    }
}
