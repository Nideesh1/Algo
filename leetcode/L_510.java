/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if(x.right != null){
            x = x.right;
            while(x.left != null){
                x = x.left;
            }
            return x;
        }
        
        //while x has a parent and is the right child of
        //of it's parent
        while(x.parent != null && x == x.parent.right){
            x = x.parent;
        }
        
        return x.parent;
    }
}

//https://leetcode.com/problems/inorder-successor-in-bst-ii/solution/
