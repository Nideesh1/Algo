/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //1st find mid point
        if(head == null || head.next == null) return;
        
        ListNode a1 = head;
        ListNode a2 = head;
        
        while(a2.next != null){
            a1 = a1.next;
            a2 = a2.next;
            
            if(a2.next == null )break;
            else a2 = a2.next;
        }
    
        
        //2nd rev the mid point
        rev(a1);
            
        
        //weave both together
        ListNode run = head;
        ListNode t1 = head;
        ListNode t2 = head;
        while(a1 != a2){
            t1 = run;
            t2 = a2;
            
            run = run.next;
            a2 = a2.next;
            
            t2.next = t1.next;
            t1.next = t2;
        }
        
    }
    
    public ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
}

//https://leetcode.com/problems/reorder-list/discuss/45080/Accepted-Answer-in-Java
