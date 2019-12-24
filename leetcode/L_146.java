class Node<K,V>{
    K key; V val; Node left; Node right;
    Node(K key, V val){
        this.key = key; this.val = val;
    }
}

class LRUCache {
    Map<Integer,Node> map; int cap; Node start; Node end;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity; 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            removeNode(n); addToTop(n);
            return (Integer) n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node n = new Node(key, value);
            n.left = null; n.right = null;
            //check size
            if(map.size() < cap){
                addToTop(n);
            }else{
                map.remove(end.key);
                removeNode(end);
                addToTop(n);
            }
            map.put(key, n);
        }else{
            Node g = map.get(key);
            g.val = value;
            removeNode(g);
            addToTop(g);
        }
    }
    
    //helper1
    //make the new node the start
    public void addToTop(Node node){
        node.right = start;
        node.left = null;
        if(start != null){
            start.left = node;
        }
        start = node;
        if(end == null){
            end = start;
        }
    } 
        
        
    //helper2
    public void removeNode(Node node){
        //left side
        if(node.left == null){
            start = node.right;
        }else{
            node.left.right = node.right;
        }
        
        //right side
        if(node.right == null){
            end = node.left;
        }else{
            node.right.left = node.left;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 //https://leetcode.com/problems/lru-cache/
 //https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
