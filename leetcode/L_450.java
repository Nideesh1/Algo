class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }
    public TreeNode dfs(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key ) {
            root.right = dfs(root.right, key);
        } else if (root.val > key) {
            root.left = dfs(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode temp = root.left;
            root = root.right;
            TreeNode leftMost = root;
            while (leftMost.left != null) {
                leftMost = leftMost.left;
            }
            
            leftMost.left= temp;
            return root;
        }
        return root;
    }
}
