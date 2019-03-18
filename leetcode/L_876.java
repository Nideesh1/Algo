/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode t = head; int size = 0;
        while(t != null){
            t = t.next; size++;
        }
        size = size/2; t= head;
        while(size != 0){
            t = t.next; size--;
        }
        return t;
    }
}

//https://leetcode.com/problems/middle-of-the-linked-list/
