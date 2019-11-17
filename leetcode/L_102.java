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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        if((root.left == null && root.right == null)) {
            List<Integer> r = new ArrayList<>();
            r.add(root.val);
            res.add(r);
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                t.add(cur.val);
                
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            res.add(new ArrayList<>(t));
        }
        return res;
    }
}

//https://leetcode.com/problems/binary-tree-level-order-traversal/
