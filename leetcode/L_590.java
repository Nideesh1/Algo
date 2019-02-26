/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }
    public void post(Node root, List<Integer> res){
        if(root == null){return;}
        for(Node n : root.children){
            post(n, res);
        }
        visit(root, res);
    }
    public void visit(Node root, List<Integer> res){
        res.add(root.val);
    }
}

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
