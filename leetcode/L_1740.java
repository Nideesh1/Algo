class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = lca(root, p, q);
        int d1 = depth(lca, p, 0);
        int d2 = depth(lca, q, 0);
        return d1 + d2;
    }
    
    public int depth(TreeNode root, int p, int dep) {
        if (root == null) return 0;
        if (root.val == p) return dep;
        int l = depth(root.left, p, dep + 1);
        if (l != 0) {
            return l;
        } else {
            l = depth(root.right, p, dep + 1);
            return l;
        }
    }
    
    public TreeNode lca (TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
