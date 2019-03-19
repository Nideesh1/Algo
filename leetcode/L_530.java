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
        List<Integer> l = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        in(root);
        int p = 0;    
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < l.size(); i++){
            min = Math.min(l.get(i) - l.get(i-1), min);
        }
        return  min;        
    }
    
        public void in(TreeNode root){
        if(root == null) return;
        in(root.left);
        visit(root);
        in(root.right);
        
        
        
    }
    public void visit(TreeNode root){
        l.add(root.val);
    }
}

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
