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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        if(root == null){return res;}
        if(root.children.isEmpty()){
            t.add(root.val); res.add(t); return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i < size; i++){
                Node n = q.poll();  t.add(n.val);
                for(Node p : n.children){
                    q.add(p);
                }
            }
            res.add(new ArrayList<>(t));
            t.clear();
        }
        return res;
    }
}


//https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
