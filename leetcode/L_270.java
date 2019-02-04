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
    public int closestValue(TreeNode root, double target) {
        int close = root.val;
        
        while(root != null){
            close = Math.abs(target - root.val) < Math.abs(target - close) ? root.val : close;
            if(close == target){ return close; }
            root = target < root.val ? root.left : root.right;
        }
        return close;
    }
}

//https://leetcode.com/problems/closest-binary-search-tree-value/description/
