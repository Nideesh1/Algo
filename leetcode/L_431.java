/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        List<Node> list = new ArrayList<>();
        list.add(root);
        return doEncode(list);
    }
    
    public TreeNode doEncode(List<Node> level){
        if(level.isEmpty()) return null;
        
        Node firstNode = level.remove(0);
        TreeNode root = new TreeNode(firstNode.val);
        
        if(firstNode.children != null) root.left = doEncode(firstNode.children);
        
        root.right = doEncode(level);
        
        return root;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if( root == null) return null;
        List<Node> level = new ArrayList<>();
        doDecode(root, level);
        return level.get(0);
    }
    
    public void doDecode(TreeNode root, List<Node> level){
        if(root == null) return;
        
        Node node = new Node(root.val, new ArrayList<>());
        level.add(node);
        
        doDecode(root.right, level);
        
        doDecode(root.left, node.children);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));


//https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/discuss/153061/Java-Solution-(Next-Level-greater-left-Same-Level-greater-right)/197436
