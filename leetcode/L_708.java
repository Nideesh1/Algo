/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node nn = new Node(insertVal, null);
            nn.next = nn;
            return nn;
        }
        Node prev = head;
        Node cur = head.next;
        boolean insert = false;
        do{
            
            if(prev.val <= insertVal && insertVal <= cur.val){
                insert = true;
            }else if(prev.val > cur.val){
                
                if(prev.val <= insertVal || insertVal <= cur.val){
                    insert = true;
                }
            }
            
            if(insert){
                prev.next = new Node(insertVal, cur);
                return head;
            }
            
            prev = cur;
            cur = cur.next;
            
        }while(head != prev);
            
            
        prev.next = new Node(insertVal, cur);
        return head;
            
    }
    
    
}

//https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/solution/
