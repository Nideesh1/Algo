/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
//My solution
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        TreeNode res = new TreeNode(l.get(0));
        System.out.println(l);
        if(l.size() == 1){return res;}
        TreeNode pointer = res;
        for(int i = 1; i < l.size(); i++){
            pointer.right = new TreeNode(l.get(i));
            pointer = pointer.right;
        }
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> l){
        if(root == null)return;
        inorder(root.left, l);
        visit(root, l);
        inorder(root.right, l);
    }
    
    public void visit(TreeNode root, List<Integer> l){
        l.add(root.val);
    }
    
}

//Inplace
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
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)return null;
        TreeNode ans = new TreeNode(0);
        cur = ans;
        recur(root);
        return ans.right;
    }
    public void recur(TreeNode root){
        if(root == null)return;
        recur(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        recur(root.right);
    }
}
