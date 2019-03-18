/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head; int last = 0;
        ListNode run = head;
        while(run != null){
            last = first.val;
            loop:
            while(run.val == last){
                run = run.next;
                if(run == null) break loop;
            }
            first.next = run;
            first = run;
            
        }
        return head;
    }
}

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
