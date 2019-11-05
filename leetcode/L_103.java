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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null) return res;
        boolean zz = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < size; i++){
                
                TreeNode cur = q.poll();
                if(zz){
                    l.add(0, cur.val);
                }else{
                    l.add(cur.val);
                }
                
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }

            }
                            zz = !zz;
            res.add(l);
        }
    return res;
    }

}

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
