class Solution {
    List<TreeNode> tot = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int t : to_delete) {set.add(t);}
        pre(root, true);
        return tot;
    }
    public TreeNode pre(TreeNode root, boolean isRoot){
        if(root == null) return null;
        boolean exclude = set.contains(root.val);
        if(!exclude && isRoot) tot.add(root);
        TreeNode left = pre(root.left, exclude);
        TreeNode right = pre(root.right, exclude);
        root.left = left; root.right = right;
        return exclude ? null : root;
    }
}

//https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/328853/JavaC%2B%2BPython-Recursion-Solution