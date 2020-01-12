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
    int ind = 0;
    public TreeNode recoverFromPreorder(String S) {
        return dfs(S, 0);
    }
    public TreeNode dfs(String s, int depth){
        int dashes = 0;
        while(ind + dashes < s.length() && s.charAt(ind + dashes) == '-' ){
            dashes++;
        }
        
        if(dashes != depth) return null;
        int next = ind + dashes;
        while(next < s.length() && s.charAt(next) != '-') next++;
        
        int val = Integer.parseInt(s.substring(ind + dashes, next));
        
        ind = next;
        
        TreeNode root = new TreeNode(val);
        TreeNode l = dfs(s, depth + 1);
        TreeNode r = dfs(s, depth + 1);
        
        root.left = l; root.right = r;
        return root;
    }
}

//https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/discuss/274656/Java-recursive-solution.
