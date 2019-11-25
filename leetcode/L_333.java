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
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(valid(root, null, null)) return count(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    public int count(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + count(root.left) + count(root.right);
    }
    
    public boolean valid(TreeNode root, Integer min, Integer max){
        if(root == null)return true;
        if(min != null && min >= root.val) return false;
        if(max != null && max <= root.val) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}
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
    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }
    
    public int[] largestBST(TreeNode node){
        if(node == null){
            return new int[]{
                Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{
                Math.min(node.val, left[0]),
                Math.max(node.val, right[1]),
                left[2] + right[2] + 1
            };
        }else{
            return new int[]{
                Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])
            };
        }
    }
}

//https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution
