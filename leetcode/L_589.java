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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }
    public void pre(Node root, List<Integer> res){
        if(root == null){return;}
        visit(root, res);
        for(Node n : root.children){
            pre(n, res);
        }
    }
    public void visit(Node root, List<Integer> res){
        res.add(root.val);
    }
}

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
