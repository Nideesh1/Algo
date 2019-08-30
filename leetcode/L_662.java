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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        q.add(root);
        map.put(root, 0);
        int start = 0;
        int end = 0;
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(i == 0) start = map.get(cur);
                if(i == size - 1) end = map.get(cur);
                if(cur.left != null){
                    map.put(cur.left, map.get(cur)*2); q.add(cur.left);
                }
                if(cur.right != null){
                    map.put(cur.right, map.get(cur)*2 + 1); q.add(cur.right);
                }
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/maximum-width-of-binary-tree/
