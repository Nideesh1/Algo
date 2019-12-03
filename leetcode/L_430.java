/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node pseudo = new Node(0, null, head, null);
        dfs(pseudo, head);
        pseudo.next.prev = null;
        return head;
    }
    
    public Node dfs(Node prev, Node cur){
        if(cur == null) return prev;
        cur.prev = prev;
        prev.next = cur;
        
        Node temp = cur.next;
        
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        
        return dfs(tail, temp);
    }
}

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solution/
