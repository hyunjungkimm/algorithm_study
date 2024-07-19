package src.leetcode;
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
class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if(list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        list1.next = mergeTwoLists(list1.next, list2);

        return list1;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode temp = answer;

        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if(list1 == null) {
            temp.next = list2;
        }else {
            temp.next = list1;
        }

        return answer.next;
    }
}

