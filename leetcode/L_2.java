/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dum = dummy;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while(p != null || q != null){
            int one = (p != null) ? p.val : 0;
            int two = (q != null) ? q.val : 0;     
            int sum = carry + one + two;
            carry = sum/10;
            dum.next = new ListNode(sum%10);
            dum = dum.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            dum.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

//https://leetcode.com/problems/add-two-numbers/solution/
