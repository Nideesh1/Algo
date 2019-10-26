/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    List<Integer> l = new ArrayList<>();
    int p = 0;
    public BSTIterator(TreeNode root) {
        in(root);
    }
    public void in(TreeNode root){
        if(root == null)return;
        in(root.left); visit(root); in(root.right);
    }
    public void visit(TreeNode root){
        l.add(root.val);
    }
    
    /** @return the next smallest number */
    public int next() {
        if(hasNext()){
          int val = l.get(p); 
          p++;
          return val;
        }   
        return 0;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p < l.size();
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
class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        in(root);
    }
    public void in(TreeNode root){
        while(root != null){
            stk.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode res = stk.pop();
        
        if(res.right != null){
            in(res.right);
        }
        return res.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stk.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 //https://leetcode.com/problems/binary-search-tree-iterator/
 //https://leetcode.com/problems/binary-search-tree-iterator/solution/
