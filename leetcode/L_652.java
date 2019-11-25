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
    Map<String,Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    
    public String dfs(TreeNode root){
        if(root == null)return "#";
        String serial = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if(count.get(serial) == 2){
            ans.add(root);
        }
        return serial;
    }
}

//https://leetcode.com/problems/find-duplicate-subtrees/solution/
