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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        //add left view, leaves, and reverse right view
        
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        
        if(!isLeaf(root)){
            res.add(root.val);
        }
        
        TreeNode l = root.left;
        while(l != null){
            if(!isLeaf(l)){
                res.add(l.val);
            }
            if(l.left != null){
                l = l.left;
            }else{
                l = l.right;
            }
        }
        
        pre(res, root);
        
        Stack<Integer> stk = new Stack<>();
        TreeNode r = root.right;
        while(r != null){
            if(!isLeaf(r)){
                stk.push(r.val);
            }
            if(r.right != null){
                r = r.right;
            }else{
                r = r.left;
            }
        }
        while(!stk.isEmpty()){
            res.add(stk.pop());
        }
        
        return res;
    }
    
    public void pre(List<Integer> res, TreeNode root){
        if(root == null)return;
        if(isLeaf(root)){
            res.add(root.val);
        }
        if(root.left != null){
            pre(res, root.left);
        }
        if(root.right != null){
            pre(res, root.right);
        }
    }
    
    public boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
}

//https://leetcode.com/problems/boundary-of-binary-tree/solution/
