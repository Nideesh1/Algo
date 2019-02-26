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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){return res;}
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode tn = q.poll();
                if(tn == null){continue;}
                in.add(tn.val);
                if(tn.left != null) q.add(tn.left);
                if(tn.right != null) q.add(tn.right);
            }
            out.add(new ArrayList<>(in));
            in.clear();
        }
        for(List<Integer> ll : out){
            double tot = 0;
            int size = 0;
            for(Integer i : ll){
                tot += i;size++;
            }
            res.add(tot/size);
            tot = 0; size = 0;
        }
        return res;
    }
}

//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
