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
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode last = cur.left;
                while(last.right != null) last = last.right;
                
                last.right = cur.right;
                
                cur.right = cur.left;
                cur.left = null;
                
            }
            cur = cur.right;
            //System.out.println(cur.val);
        }
    }
}

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/37010/Share-my-simple-NON-recursive-solution-O(1)-space-complexity!
