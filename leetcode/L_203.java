/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) return null;
        if(head.next == null && head.val == val) return null;
        if(head.next == null && head.val != val) return head;
        while(head.next != null && head.val == val) head = head.next ;
        
        ListNode prev = head;
        ListNode cur = head.next;
        
        loop:
        while(cur != null){
            if(cur.val != val){
                prev = cur;
                cur = cur.next;
            }
            else if(cur.val == val){
                prev.next = cur.next;
                cur = prev.next;
                if(cur == null) {
                    break loop;
                    
                }
            }
        }
        return head.val == val ? null : head;
    }
}

//https://leetcode.com/problems/remove-linked-list-elements/
