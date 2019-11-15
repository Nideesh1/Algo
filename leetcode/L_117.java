/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node res = root;
        while(root != null){
            
            Node level = new Node(0);
            Node run = level;
            
            while(root != null){
                if(root.left != null){
                    run.next = root.left; run = run.next;
                }
                if(root.right != null){
                    run.next = root.right; run = run.next;
                }
                
                root = root.next;
            }
            
            root = level.next;
        }
        return res;
    }
}

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
