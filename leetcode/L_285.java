/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            p = p.right;
            while(p.left != null)p = p.left;
            return p;
        }
        
        Stack<TreeNode> stk = new Stack<>();
        int prevTarget = Integer.MIN_VALUE;
        while(!stk.isEmpty() || root != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            if(prevTarget == p.val) return root;
            prevTarget = root.val;
            
            root = root.right;
        }
        
        return null;
    }
}

//https://leetcode.com/problems/inorder-successor-in-bst/
