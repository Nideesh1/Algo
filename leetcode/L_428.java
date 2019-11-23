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
class Codec {
    String NN = "X";
    String separator = ",";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        ser(root, sb);
        return sb.toString();
    }
    
    public void ser(Node root, StringBuilder sb){
        if(root == null){
            sb.append(NN);
            sb.append(separator);
        }else{
            sb.append(root.val);
            sb.append(separator);
            
            int childSize = root.children.size();
            sb.append(childSize);
            sb.append(separator);
            
            
            for(Node n : root.children){
                ser(n, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> deq = new LinkedList<>(Arrays.asList(data.split(separator)));
        return des(deq);
    }
    
    public Node des(Queue<String> deq){
        String s = deq.poll();
        if(s.equals(NN)){
            return null;
        }
        
        int rootVal = Integer.valueOf(s);
        String numChild = deq.poll();
        int num = Integer.valueOf(numChild);
        
        Node root = new Node(rootVal);
        root.children = new ArrayList<>();
        for(int i = 0; i < num; i++){
            root.children.add(des(deq));
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/190318/Serialize-and-Deserialize-Binary-and-N-ary-Tree-Summary
