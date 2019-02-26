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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)return true;
        int value = root.val;
        return recur(root, value);
    }
    public boolean recur(TreeNode root, int value){
        if(root.val == value && root.left == null && root.right == null){
            return true;
        }
        if(root.val != value){return false;}
        if(root.left == null) return recur(root.right, value);
        if(root.right == null) return recur(root.left, value);        
        return recur(root.left, value) && recur(root.right, value);
    }
}

//https://leetcode.com/problems/univalued-binary-tree/description/
