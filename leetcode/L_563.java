//mine
class Solution {
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        int tilt = 0;
        tilt += Math.abs(sum(root.left) - sum(root.right));
        tilt += findTilt(root.left);
        tilt += findTilt(root.right);
        return tilt;
    }
    
    public int sum(TreeNode root){
        if(root == null) return 0;
        int sum = 0;
        sum += sum(root.left);
        sum += sum(root.right);
        return root.val + sum;
    }
}

//not mine
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
    
    int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return tilt;
        recur(root);
        return tilt;
    }
    
    public int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        //This is taking care of global tilt
        tilt += Math.abs(left - right);
        
        //This is returning sum
        return root.val + left + right;
    }
}

//https://leetcode.com/problems/binary-tree-tilt/solution/
