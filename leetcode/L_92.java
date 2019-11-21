/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        
        ListNode p1 = null;
        ListNode c1 = dum;
        
        //move p1, c1 to right place
        for(int i = 0; i < m; i++){
            p1 = c1; 
            c1 = c1.next;
        }
        
        //start p2, c2 and send them to the end
        ListNode p2 = p1;
        ListNode c2 = c1;
        ListNode next;
        for(int i = m; i <= n; i++){
            next = c2.next;
            c2.next = p2;
            
            p2 = c2;
            c2 = next;
        }
        
        c1.next = c2;
        p1.next = p2;
        
        return dum.next;
    }
}

//https://leetcode.com/problems/reverse-linked-list-ii/discuss/30667/Easy-understanding-java-solution
