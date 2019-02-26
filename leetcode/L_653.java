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
    public boolean findTarget(TreeNode root, int k) {
      List<Integer> l = new ArrayList<>();
        inOrder(root, l);
        int i = 0; int j = l.size() - 1;
        while(i < j){
            int sum = l.get(i) + l.get(j);
            if(sum == k)return true;
            if( sum < k){i++;}
            if(sum > k){j--;}
        }
        return false;
    }
    
    public void inOrder(TreeNode root, List<Integer> l){
        if(root == null)return;
        inOrder(root.left, l);
        visit(root, l);
        inOrder(root.right, l);
    }
    public void visit(TreeNode root, List<Integer> l){
        l.add(root.val);
    }
}

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
