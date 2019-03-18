/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode one = headA; ListNode two = headB;
        while(one != two){

            if(one == null) {one = headB;}else{
                            one = one.next;
            }

            if(two == null) {two = headA;}else{
                            two = two.next;
            }
        }
        return one;
    }



    }
    
    //https://leetcode.com/problems/intersection-of-two-linked-lists/
