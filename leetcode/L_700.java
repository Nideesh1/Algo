/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //recur
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){return null;}
        if(root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        if(left == null && right == null){return null;}
        if(left == null){
            return right;
        }
        return left;
    }
}

//Iterative
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)return null;
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
