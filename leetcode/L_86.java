/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode befh = new ListNode(0);
        ListNode bef = befh;
        ListNode afh = new ListNode(0);
        ListNode af = afh;
        
        while(head != null){
            if(head.val < x){
                bef.next = head;
                bef = bef.next;
            }else{
                af.next = head;
                af = af.next;
            }
            
            head = head.next;
        }
        
        af.next = null;
        bef.next = afh.next;
        return befh.next;
    }
}

//https://leetcode.com/problems/partition-list/solution/
