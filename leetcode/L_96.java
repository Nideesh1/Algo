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
    public void recoverTree(TreeNode root) {
        TreeNode pred = null;
        TreeNode x= null;
        TreeNode y= null;
        
        Stack<TreeNode> stk = new Stack<>();
        
        while(!stk.isEmpty() || root != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            
            
            //nique to this problem
            if(pred != null && root.val < pred.val){
                y = root;
                if(x == null) x = pred;
                else break;
            }
            pred = root;
            
            
            
            root = root.right;
        }
        
        swap(x,y);
    }
    
    public void swap(TreeNode x, TreeNode y){
        int v = x.val;
        x.val = y.val;
        y.val = v;
    }
}

//https://leetcode.com/problems/recover-binary-search-tree/solution/
