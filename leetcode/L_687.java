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
    public  int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        recur(root);
        return max;
    }
    
    public int recur(TreeNode root){       
        if(root == null){return 0;}

        int l = recur(root.left);
        int r = recur(root.right);
        int lar = 0; int rar = 0;
        if(root.left != null && root.left.val == root.val){
            lar += l + 1;
        }

        if(root.right != null && root.right.val == root.val){
            rar += r + 1;
        }
        max = Math.max(max, lar + rar);
        return Math.max(lar,rar);
    }
}

//https://leetcode.com/problems/longest-univalue-path/description/
