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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, false);
        String tree2 = preorder(t, false);
        System.out.println(tree1);
        System.out.println(tree2);
        return (tree1.indexOf(tree2) >= 0);
    }
    
    public String preorder(TreeNode n, boolean left){
        if(n == null){
            if(left){
                return "lnull";
            }else{
                return "rnull";
            }
        }
        return "->" + n.val + "->" + preorder(n.left, true) + "->" + preorder(n.right,false);
        
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
    public boolean equals(TreeNode s, TreeNode t){
        if(s==null && t==null)return true;
        if(s == null || t == null) return false;
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return recur(s, t);
    }
    
    public boolean recur(TreeNode s, TreeNode t){
        return s != null && (equals(s, t) || recur(s.left, t) || recur(s.right, t));
    }
}
