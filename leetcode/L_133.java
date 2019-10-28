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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer,Node> map = new HashMap<>();
        return dfs(map, node);
    }
    public Node dfs(Map<Integer,Node> map, Node node){
        if(node == null) return null;
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        
        List<Node> l = new ArrayList<>();
        map.put(node.val, new Node(node.val, l));
        for(Node nei : node.neighbors){
            l.add(dfs(map, nei));
        }
        return map.get(node.val);
    }
}

//https://leetcode.com/problems/clone-graph/discuss/415034/Java%3A-DFS-100-faster-and-97.65-less-memory-dfs
