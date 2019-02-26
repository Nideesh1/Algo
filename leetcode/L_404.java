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
    public int sumOfLeftLeaves(TreeNode root) { List<Integer> l = new ArrayList<>();
        recur(root,null, l);int sum = 0;
        for(Integer i : l){sum+= i; }
        return sum;                                               
    }
    public void recur(TreeNode root, TreeNode parent, List<Integer> l  ){
        if(root == null) return;

        if(parent != null &&  parent.left != null){
            if(root == parent.left && root.left == null && root.right == null){
                //System.out.println(root.val);
                l.add(root.val);
            }
        }        
        if(root.left != null){
             recur(root.left, root, l);
        }
        if(root.right != null){
        recur(root.right, root, l);             
        }

    }
}

//https://leetcode.com/problems/sum-of-left-leaves/description/
