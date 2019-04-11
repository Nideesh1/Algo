//Recollision
class MyHashMap {
    
	/** Store the Bucket's start nodes in the the arraylist. */
    List<HashNode> buckets;
    int numberOfBuckets;
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        numberOfBuckets = 10000;
        buckets = new ArrayList<HashNode>();
        
        for(int i=0;i<numberOfBuckets;i++) 
            buckets.add(null);
    }
    
	/**
	* Helper method to get the bucket index for remove, put and get methods. 
	*/
    public int getBucketIndex(int key) {
        return Integer.hashCode(key) % numberOfBuckets;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        HashNode node = buckets.get(bucketIndex);
        while(node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            
            node = node.next;
        }

        node = buckets.get(bucketIndex);
        HashNode newNode = new HashNode(key, value);
        newNode.next = node;
        buckets.set(bucketIndex, newNode);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
        HashNode node = buckets.get(bucketIndex);
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        HashNode node = buckets.get(bucketIndex);
        HashNode prev = null;
        while (node != null) {
            if(node.key == key) {
                break;
            }
            
            prev = node;
            node = node.next;
        }
        
        if (node == null) return ;
        
        if (prev != null) {
            prev.next = node.next;
        } else {
            buckets.set(bucketIndex, node.next);
        }
    }
}

/**
* Class to represent the single hash node. 
*/
class HashNode {
    int key;
    int value;
    
    HashNode next;
    
    HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

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
