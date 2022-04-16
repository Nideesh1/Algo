/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node pre = new Node(0,null,head,null);
        Node dummy = pre;
        Node cur = head;

        Stack<Node> stk = new Stack<>();        
        stk.push(cur);
        while (!stk.isEmpty()) {
            cur = stk.pop();
            cur.prev = pre;
            pre.next = cur;
            
            if (cur.next != null) stk.push(cur.next);
            if (cur.child != null) {
                stk.push(cur.child);
                cur.child = null;
            }
            pre = cur;
            cur = cur.next;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}
