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
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }
    public boolean dfs(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){return true;}
        if(root1 == null || root2 == null){return false;}
        return root1.val == root2.val && dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }
}

//https://leetcode.com/problems/symmetric-tree/description/
