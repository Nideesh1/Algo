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
    int pointer = 0;
    int[] pre;
    int[] in; 
    Map<Integer,Integer> map = new HashMap<>();
    //k,v -> key is value of node, value is position(index) of that value in inorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.pre = preorder;
        //this.in = inorder;
        
        int i = 0;
        for(int k : inorder){
            map.put(k, i++);
        }
        return dfs(0, inorder.length);
    }
    
    public TreeNode dfs(int left, int right){
        if(left == right){
            return null;
        }
        int root_val = pre[pointer];
        pointer++;
        int root_pos = map.get(root_val);
        
        TreeNode node = new TreeNode(root_val);
        
        node.left = dfs(left, root_pos);
        node.right = dfs(root_pos + 1, right);
        
        return node;
        
    }
}

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
