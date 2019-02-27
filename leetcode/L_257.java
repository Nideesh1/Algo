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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        recur(root, res, "");
        return res;
    }
    
    public void recur(TreeNode root, List<String> res, String prev){
        if(root == null) { return; }
        prev += Integer.toString(root.val);
        if( (root.left == null) && (root.right == null)){
            res.add(prev);
        }else{
            prev += "->";
            recur(root.left, res, prev);
            recur(root.right, res, prev);
        }
        
    }
}

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    LinkedList<String> paths = new LinkedList();
    if (root == null)
      return paths;

    LinkedList<TreeNode> node_stack = new LinkedList();
    LinkedList<String> path_stack = new LinkedList();
    node_stack.add(root);
    path_stack.add(Integer.toString(root.val));
    TreeNode node;
    String path;
    while ( !node_stack.isEmpty() ) {
      node = node_stack.pollLast();
      path = path_stack.pollLast();
      if ((node.left == null) && (node.right == null))
        paths.add(path);
      if (node.left != null) {
        node_stack.add(node.left);
        path_stack.add(path + "->" + Integer.toString(node.left.val));
      }
      if (node.right != null) {
        node_stack.add(node.right);
        path_stack.add(path + "->" + Integer.toString(node.right.val));
      }
    }
    return paths;
  }
}

//https://leetcode.com/problems/binary-tree-paths/solution/
