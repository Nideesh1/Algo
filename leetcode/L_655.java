class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int rows = height(root), cols = (int) (Math.pow(2, rows) - 1);
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add("");
            }
            res.add(row);
        }
        pop(root, res, 0, 0, cols - 1);
        return res;
    }
    
    public void pop(TreeNode root, List<List<String>> res, int rows, int i, int j) {
        if (root == null) return;
        int col = (i + j) / 2;
        res.get(rows).set(col, root.val + "");
        pop (root.left, res, rows + 1, i, col - 1);
        pop (root.right, res, rows + 1, col + 1, j);
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

