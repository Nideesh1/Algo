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
        ListNode cur = head;
        ListNode pre = dum;
        ListNode next = null;
        
        while(cur != null){
            
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            
            
            cur.next = pre.next;
            pre.next = cur;
            pre = dum;
            cur = next;
            
        }
        
        return dum.next;
    }
}

//https://leetcode.com/problems/insertion-sort-list/discuss/46420/An-easy-and-clear-way-to-sort-(-O(1)-space-)
