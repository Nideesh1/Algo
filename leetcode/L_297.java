/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        return sb.toString();
    }
    public void pre(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('#').append(',');
        }else{
            visit(root, sb);
            pre(root.left, sb);
            pre(root.right, sb);
        }
    }
    public void visit(TreeNode root, StringBuilder sb){
        sb.append(root.val).append(',');
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> q = new LinkedList<>();
        for(String s : data.split(",")){
            q.add(s);
        }
        return make(q);
    }
    public TreeNode make(Queue<String> q){
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode par = new TreeNode(Integer.valueOf(s));
        par.left = make(q);
        par.right = make(q);
        return par;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
