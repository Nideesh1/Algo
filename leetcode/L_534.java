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
    
    
    //Keep track of max height at every node
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        recur(root);
        return ans- 1;
    }
    
    public int recur(TreeNode root){
        if(root == null) return 0;
    
        int ld = recur(root.left);
        int rd = recur(root.right);
        
        int d = 1 + ld + rd;
        
        //This global ans keeps track of height at each node
        ans = Math.max(ans, d);
        
        //This returns hieght
        return Math.max(ld, rd) + 1;
    }
}
//https://leetcode.com/problems/diameter-of-binary-tree/
