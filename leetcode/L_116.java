/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        List<List<Node>> tot = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        q.add(root); 
        while(!q.isEmpty()){
            int size = q.size();
            List<Node> l = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                l.add(cur);
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            tot.add(new ArrayList<>(l));
        }
        
        for(int i = 0; i < tot.size(); i++){
            if(tot.get(i).size() == 1){
                tot.get(i).get(0).next = null;
            }else{
                for(int j = 1; j < tot.get(i).size(); j++){
                    tot.get(i).get(j-1).next = tot.get(i).get(j);
                }
                tot.get(i).get(tot.get(i).size()-1).next = null;
            }
        }
        
        return root;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node level_start = root;
        Node cur = root;
        while(level_start != null){
            cur = level_start;
            while(cur != null){
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                
                cur = cur.next;
            }
            level_start = level_start.left;
        }
        return root;
    }
}

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
