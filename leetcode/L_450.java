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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.val = suc(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = pre(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    //right, then all left
    public int suc(TreeNode root){
        root = root.right;
        while(root.left != null) root = root.left;
        return root.val;
    }
    
    //left, then all right
    public int pre(TreeNode root){
        root = root.left;
        while(root.right != null) root = root.right;
        return root.val;
    }
}

//https://leetcode.com/problems/delete-node-in-a-bst/solution/
