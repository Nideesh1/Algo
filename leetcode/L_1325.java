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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        postDel(root, target);
        if(isTarget(root, target) && isLeaf(root)) root = null;
        return root;
    }
    
    public void postDel(TreeNode root, int target){
        if(root == null) return;
        postDel(root.left, target);
        postDel(root.right, target);
        if(root.left != null && isLeaf(root.left)){
            if(isTarget(root.left, target)) root.left = null;
        }
        if(root.right != null && isLeaf(root.right)){
            if(isTarget(root.right, target)) root.right = null;
        }
        
     }
    
    public boolean isLeaf(TreeNode leaf){
        return leaf.left == null && leaf.right == null;
    }
    
    public boolean isTarget(TreeNode root, int target){
        if(root == null) return false;
        return root.val == target;
    }
}
