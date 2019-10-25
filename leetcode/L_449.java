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
        if(root == null)return;
        visit(root, sb);
        pre(root.left, sb);
        pre(root.right, sb);
    }
    public void visit(TreeNode root, StringBuilder sb){
        sb.append(root.val); sb.append(' ');
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> q = new LinkedList<>();
        String[] ar = data.split("\\s");
        for(String s : ar){
            q.add(s);
        }
        return build(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
    }
    
    public TreeNode build(int min, int max, Queue<String>q){
        if(q.isEmpty()) return null;
        int val = Integer.valueOf(q.peek());
        if(val < min || val > max ){return null;}
        q.poll();
        TreeNode par = new TreeNode(val);
        par.left = build(min, val, q);
        par.right = build(val, max, q);
        return par;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//https://leetcode.com/problems/serialize-and-deserialize-bst/
//https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
