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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, long low, long high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }
}

//Edge case https://leetcode.com/problems/validate-binary-search-tree/discuss/32109/My-simple-Java-solution-in-3-lines
//https://leetcode.com/problems/validate-binary-search-tree/
