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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        in(root);

        int l = 0;
        int r = list.size() - 1;
        
        TreeNode res = build(l, r);
        
        return res;
    }
    
    public TreeNode build(int l, int r){
        if(l > r) return null;
        if(l == r) return new TreeNode(list.get(l));
        int m = (l + r) / 2;
        TreeNode res = new TreeNode(list.get(m));
        res.left = build(l, m - 1);
        res.right = build(m + 1, r);
        return res;
    }
    
    public void in(TreeNode root){
        if(root == null) return;
        in(root.left);
        list.add(root.val);
        in(root.right);
    }
}
