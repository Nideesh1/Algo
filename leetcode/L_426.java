/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        
        if(root == null) return null;
        in(root);
        first.left = last;
        last.right = first;
        return first;
    }
    public void in(Node root){
        if(root == null) return;
        in(root.left);
        visit(root);
        in(root.right);
    }
    public void visit(Node root){
        if(first == null){
            first = root;
        }
        if(last == null){
            last = root;
        }
        else if(last != null){
            root.left = last; 
            last.right = root;
            last = root;
        }
    }
}

//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/
