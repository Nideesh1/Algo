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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int dl = height(root.left);
        int dr = height(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(dl - dr) <= 1);
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

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
    public boolean result = true;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return result;
    }
    
    public int recur(TreeNode root){
        if(root == null) return 0 ;
        int l = recur(root.left);
        int r = recur(root.right);
        if(Math.abs(l - r) > 1){
            result = false;
        }
        return Math.max(l,r) + 1;
    }
}

//https://leetcode.com/problems/balanced-binary-tree/submissions/
