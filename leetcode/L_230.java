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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        //inorder
        if(root == null) return 0;
        while(!stk.isEmpty() || root != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            if(--k == 0) return root.val;
            
            root = root.right;
            
        }
        
        return -1;
    }
}

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
