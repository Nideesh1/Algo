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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null); return res;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> l = dfs(start, i - 1);
            List<TreeNode> r = dfs(i + 1, end);
            
            for(TreeNode ln : l){
                for(TreeNode rn : r){
                    TreeNode cur = new TreeNode(i);
                    cur.left = ln;
                    cur.right = rn;
                    res.add(cur);
                }
            }
    
        }
        
        return res;
    }
    
    
}

//https://leetcode.com/problems/unique-binary-search-trees-ii/solution/
