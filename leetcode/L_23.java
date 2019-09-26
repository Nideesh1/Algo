/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
            return divQ(lists, 0, lists.length-1);
    }
    
    public ListNode divQ(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];
        if(l < r){
            int m = l + (r - l)/2;
            ListNode one = divQ(lists, l, m);
            ListNode two = divQ(lists, m+1, r);
            return mer2It(one, two);
        }
        return null;
    }
    
    public ListNode mer2Rec(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mer2Rec(l1.next, l2);
            return l1;
        }else{
            l2.next = mer2Rec(l1, l2.next);
            return l2;
        }
    }
    public ListNode mer2It(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode run = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                run.next = l1;
                l1 = l1.next;
            }else{
                run.next = l2;
                l2 = l2.next;
            }
            run = run.next;
        }
        if(l1 == null) run.next = l2;
        if(l2 == null) run.next = l1;
        return res.next;
    }
}
//https://leetcode.com/problems/merge-k-sorted-lists/
