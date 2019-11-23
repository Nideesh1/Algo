/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //split the odd and even ndoes apart
        
        if(head == null) return null;
        
        ListNode odd = head; 
        ListNode even = head.next;
        ListNode evenhead = even;
        
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}

//https://leetcode.com/problems/odd-even-linked-list/solution/
