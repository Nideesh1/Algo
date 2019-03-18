/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
            if(head == null) return true;
        if(head.next == null ) return true;
        
           int size = 0;
           ListNode dum = head;
           while(dum != null){
               size++; dum = dum.next;
           }
           size = size/2;
           size--;
           dum = head;
           ListNode sec = dum;
           while(size != 0){ size--;
               dum = dum.next;
           }
           sec = dum.next;
           dum.next = null;
           sec = rev(sec);
            dum = head;
            while(dum != null){
                if(dum.val != sec.val){
                    return false;
                }
                dum = dum.next;
                sec = sec.next;
            }
        
        
           return true;
    }
    
    public ListNode rev ( ListNode n){
        ListNode pre = null;
        ListNode cur = n;
        ListNode next = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

//https://leetcode.com/problems/palindrome-linked-list/
