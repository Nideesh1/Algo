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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer,Integer> childToParent = new HashMap<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode tn = q.poll();
                if(tn == null)continue;
                in.add(tn.val);
                if(tn.left != null){
                    q.add(tn.left); childToParent.put(tn.left.val, tn.val);
                }
                if(tn.right != null){
                    q.add(tn.right); childToParent.put(tn.right.val, tn.val);
                }
            }
            out.add(new ArrayList<>(in));
            in.clear();
        }
        for(List<Integer> list : out){
            if(list.contains(x) && list.contains(y) && childToParent.get(x) != childToParent.get(y)){
                return true;
            }
        }
        return false;
    }
}

//https://leetcode.com/problems/cousins-in-binary-tree/description/
