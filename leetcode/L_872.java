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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        recur(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        recur(root2, l2);        
        //System.out.println(l1);
        //System.out.println(l2);
        return l1.equals(l2);
    }
    
    public void recur(TreeNode root, List<Integer> l){
        if(root == null){return;}
        if(root.left == null && root.right == null){
            l.add(root.val);
            return;
        }
        recur(root.left, l);
        recur(root.right, l);
    }
}

//https://leetcode.com/problems/leaf-similar-trees/description/
