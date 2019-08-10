/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        Stack<ListNode> stk = new Stack<>();
        int size = 0;
        ListNode t = head;
        while(t != null){
            size++;
            if(stk.isEmpty() || stk.peek().val >= t.val){
                stk.push(t);
            }else{
                
                while(!stk.isEmpty() && t.val > stk.peek().val){
                    map.put(stk.pop(), t.val);
                }
                stk.push(t);
            }
            t = t.next;
        }
        int[] res = new int[size];
        for(int i = 0; i < res.length; i++){
            if(!map.containsKey(head)){
                res[i] = 0;
            }else{
                res[i] = map.get(head);
            }
            head = head.next;
        }
        return res;
    }
}
//https://leetcode.com/problems/next-greater-node-in-linked-list/
