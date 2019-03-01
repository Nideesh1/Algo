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
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        recur(set, root);
        if(set.size() == 1) return -1;
        set.pollFirst();
        return set.first();
    }
    public void recur(Set<Integer> set, TreeNode root){
        if(root == null)return;
        recur(set, root.left);
        visit(set, root);
        recur(set, root.right);
    }
    public void visit(Set<Integer> set, TreeNode root){
        set.add(root.val);
    }
}

//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
