class MyHashMap {
    
    Node[] arr = new Node[10000];
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key); int idx = hash % arr.length;
        if(arr[idx] == null){
            arr[idx]  = new Node(-1,-1, hash);
        }
            Node t = find(arr[idx], key);
            if(t.next == null){
                t.next = new Node(key, value, hash);
            }else{
                t.next.v = value;
            }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key); int idx = hash % arr.length;
        if(arr[idx] == null){
            return -1;
        }
            Node t = find(arr[idx], key);
            if(t.next == null){
                return -1;
            }else{
                return t.next.v;
            }
        
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key); int idx = hash % arr.length;
        if(arr[idx] == null){
            return;
        }
            Node t = find(arr[idx], key);
            if(t.next == null){
                return;
            }else{
                t.next = t.next.next;
            }
        
    }
    
    int hash(int k){ return Integer.hashCode(k);}
    
    Node find(Node start, int k){
        Node prev = null; Node curr = start;
        while(curr != null && curr.k != k){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    class Node{
        int k; int v; int hash; Node next; public Node(int k, int v, int hash){
            this.k = k; this.v = v; this.hash = hash; this.next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 
 //https://leetcode.com/problems/design-hashmap/description/
