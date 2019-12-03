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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode x = root;
        if (null != x) q.offer(x);
        
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (null != node.left)  q.offer(node.left);
                if (null != node.right) q.offer(node.right);
            }
            res.add(max);
        }
        
        return res;
    }
}

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/discuss/98976/Java-BFS
