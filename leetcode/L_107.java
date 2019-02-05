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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        
        if(root == null){return res;}
        if(root.left == null && root.right == null){ l.add(root.val); res.add(l); return res;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode tn = q.poll();
                l.add(tn.val);
                if(tn.left != null){ q.add(tn.left);}
                if(tn.right != null){ q.add(tn.right);}
            }
            res.add(new ArrayList<>(l)); l.clear();
        }
        Collections.reverse(res);
        return res;
    }
}

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
