//recur
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}


//iter
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        while(root.val < L || root.val > R){
            if(root.val < L){root = root.right;}
            if(root.val > R){root = root.left;}
        }
        TreeNode l = root; TreeNode r = root; TreeNode parent = root;
        
        while( l != null){
            
            if(l.val == L){
                l.left = null; break;
            }
            if(l.val < L){
                parent.left = l.right;
                l = l.right;
            }
            if(l.val > L){
                parent = l;
                l = l.left;
            }
        }
        while(r != null){
            if(r.val == R){
                r.right = null; break;
            }
            if(r.val > R){
                parent.right = r.left;
                r = r.left;
            }
            if(r.val < R){
                parent = r;
                r = r.right;
            }
        }
        return root;
        
    }
}
//https://leetcode.com/problems/trim-a-binary-search-tree/
