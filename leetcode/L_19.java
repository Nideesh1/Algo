/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        
        int length = 0;
        ListNode first = dum.next;
        while(first != null){
            length++;
            first = first.next;
        }
        length -= n;
        first = dum;
        while(length > 0){
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        
        return dum.next;
    }
}

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
