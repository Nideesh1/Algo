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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){return 0;}
        if(root.left == null && root.right == null){return 1;}
        q.add(root);
        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            d++;
            for(int i = 0; i < size; i++){
                TreeNode tn = q.poll();
                if(tn.left == null && tn.right == null){return d;}
                if(tn.left != null)q.add(tn.left);
                if(tn.right != null)q.add(tn.right);
            }
        }
        return 0;
    }
}
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null ) return 1;
        
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(min, minDepth(root.left));
        }

        if(root.right != null){
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }
}

//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
//https://leetcode.com/problems/minimum-depth-of-binary-tree/solution/
