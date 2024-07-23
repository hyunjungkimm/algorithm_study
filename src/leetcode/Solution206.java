package src.leetcode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode answer = new ListNode();
        ListNode temp = answer;

        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while(!stack.isEmpty()) {
            temp.val = stack.pop();
            if(!stack.isEmpty()){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = new ListNode();
        ListNode answer = solution206.reverseList(listNode);

        while(answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}