/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        
        ListNode dum = new ListNode(0);
        ListNode prev = dum;
        ListNode cur = head;
        ListNode next = null;
        
        while(cur != null){
            
            next = cur.next;
            while(prev.next != null && prev.next.val < cur.val){
                prev = prev.next;
            }
            
            
            cur.next = prev.next;
            prev.next = cur;
            
            //reset and move forward
            prev = dum;
            cur = next;
            
        }
        
        return dum.next;
    }
}

//https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)
