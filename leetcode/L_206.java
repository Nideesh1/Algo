/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next =  null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
            
        return prev;
    }
}

/*
        if(head == null || head.next == null) return head;
        
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        */

//https://leetcode.com/problems/reverse-linked-list/
