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
        ListNode dum = new ListNode(0);
        ListNode slow = dum;
        dum.next = head;
        ListNode fast = head;
        
        while(fast != null){
            
            while(fast.next != null && (fast.val == fast.next.val)){
                fast = fast.next;
            }
            
            if(slow.next != fast){
                slow.next = fast.next;
                fast = slow.next;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
            
        }
        
        return dum.next;
    }
}
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
