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
    
    int pre_idx = 0;
    int[] pre;
    int[] in;
    
    Map<Integer,Integer> inMap = new HashMap<>();
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx = 0;
        this.pre = preorder;
        this.in = inorder;
        for(Integer i : in){
            inMap.put(i, idx++);
        }
        return dfs(0, pre.length - 1);
    }
    
    public TreeNode dfs(int i, int j){
        if(i > j){
            return null;
        }
        
        int rval = pre[pre_idx];
        int index = inMap.get(rval);
        
        TreeNode root = new TreeNode(rval);
        
        pre_idx++;
        root.left = dfs(i, index - 1);
        root.right = dfs(index + 1, j);
        
        return root;
    }
}
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
