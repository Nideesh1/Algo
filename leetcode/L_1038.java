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
    int count = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        visit(root);
        dfs(root.left);
    }
    public void visit(TreeNode root){
        count += root.val;
        root.val = count;
        System.out.println("count is " + count);
        System.out.println(root.val);
    }
}

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
