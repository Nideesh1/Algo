/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public ListNode sortList(ListNode head) {
        ListNode first = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                

                
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);


                prev = merge(left, right, prev);
                
                //ll(dummy);
                
            } 
            System.out.println();
            ll(dummy.next);
            System.out.println();
            
        }
        
        return dummy.next;
    }
    
    public void ll(ListNode start){
        while(start != null){
            System.out.print(start.val + " ");
            start = start.next;
        }
    }
    
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
    	
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = sortList(slow.next);
        slow.next = null;
            
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode one, ListNode two){
        if(one == null) return two;
        if(two == null) return one;
        
        if(one.val < two.val){
            one.next = merge(one.next, two); return one;
        }else{
            two.next = merge(one, two.next); return two;
        }
    }
}
//https://www.youtube.com/watch?v=WVl2QSe4R14&feature=youtu.be&list=PLRdD1c6QbAqJn0606RlOR6T3yUqFWKwmX
//https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity
