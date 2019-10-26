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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int left = dfs(root.left);
        left = Math.max(0, left);
        int right = dfs(root.right);
        right = Math.max(0, right);
        
        int inc = root.val + left + right;
        max = Math.max(max, inc);
        
        
        return root.val + Math.max(left, right);
        
    }
}

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
