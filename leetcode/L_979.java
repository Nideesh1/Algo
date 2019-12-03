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
    public int distributeCoins(TreeNode root) {
        int res = 0;
        
        if(root.left != null){
            res += distributeCoins(root.left);
            root.val += root.left.val - 1;
            res += Math.abs(root.left.val - 1);
        }
        
        if(root.right != null){
            res += distributeCoins(root.right);
            root.val += root.right.val - 1;
            res += Math.abs(root.right.val - 1);
        }
        
        return res;
    }
}
//https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC%2B%2BPython-Recursive-Solution
