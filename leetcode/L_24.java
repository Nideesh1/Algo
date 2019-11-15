/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null&& cur.next.next != null){
            ListNode fir = cur.next;
            ListNode sec = cur.next.next;
            
            fir.next = sec.next;
            
            cur.next = sec;
            cur.next.next = fir;
            
            cur = sec.next;
        }
        
        return dummy.next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
        
    }
}

//https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11030/My-accepted-java-code.-used-recursion.
//https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share

