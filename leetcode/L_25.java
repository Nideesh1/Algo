/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)return head;
        ListNode dum = new ListNode(-1);
        dum.next = head;
        
        ListNode begin = dum;
        int i = 0;
        while(head != null){
            i++;
            if(i % k == 0){
                begin = rev(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return dum.next;
    }
    
    public ListNode rev(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode cur = begin.next;
        ListNode next;
        ListNode first = cur;
        while(cur != end){
            next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur;
        return first;
    }
}


//https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
