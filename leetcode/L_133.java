class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node res = new Node(node.val, new ArrayList<>());
        Map<Node,Node> map = new HashMap<>();
        map.put(node, res);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!map.containsKey(cur)){
                map.put(cur, new Node(cur.val, new ArrayList<>()));
            }
            if(map.get(cur).neighbors.isEmpty()){
                
                for(Node nei : cur.neighbors){
                    
                    if(!map.containsKey(nei)){
                        map.put(nei, new Node(nei.val, new ArrayList<>()));
                    }
                    
                    
                    map.get(cur).neighbors.add(map.get(nei));
                    q.add(nei);
                    
                }
                
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/clone-graph/discuss/413958/Java-BFS-and-Hashmap

