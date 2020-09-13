class MyHashMap<K,V> {
    private static final double LOAD_FACTOR = 0.75;
    private Node<K,V>[] nodes;
    private int size; // number of keys

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[50];
        size = 0;
    }
    
    /** value will always be non-negative. */
    public void put(K key, V value) {
        int idx = hash(key);
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        nodes[idx] = new Node(key, value, nodes[idx]);
        size++;
        
        double loadFactor = (double) size / nodes.length;
        if (loadFactor > LOAD_FACTOR) {
            rehash();
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(K key) {
        int idx = hash(key);
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return (int) x.value;
            }
        }
        return  -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(K key) {
        
        int idx = hash(key);
        Node pre = new Node(-1, -1, nodes[idx]); // sentinal node before list head
        for (Node prev = pre; prev.next != null; prev = prev.next) {
            if (prev.next.key.equals(key)) {
                prev.next = prev.next.next;
                break;
            }
        }
        nodes[idx] = pre.next;
		size--;
    }
    
    private int hash(K key) {
        return  (Integer) key % nodes.length;
    }
    
    private void rehash() {
        Node[] tmp = nodes;
        nodes = new Node[tmp.length * 2];
        size = 0;
        for (Node head: tmp) {
            for (Node x = head; x != null; x = x.next) {
                put((K) x.key, (V) x.value);
            }
        }
    }
    
    class Node<K,V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}

//https://leetcode.com/problems/design-hashmap/discuss/270685/Java-Separate-Chaining-with-rehashing
