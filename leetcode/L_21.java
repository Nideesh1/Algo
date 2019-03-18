/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2; if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(-1);
        ListNode pre = dum;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1; l1  = l1.next;
            }else{
                pre.next = l2; l2 = l2.next;
            }
            pre = pre.next;
        }
        
        pre.next = l1 == null ? l2 : l1;
        
        return dum.next;
    }
}

//https://leetcode.com/problems/merge-two-sorted-lists/

