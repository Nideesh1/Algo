class LFUCache<K,V> {
    class Node<K,V> {
        K key;
        V val;
        int cnt;
        Node prev, next;
        Node(K key, V val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }
    
    class DLList {
        Node head, tail;
        int size;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        
        //we're adding to right after head
        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }
    
    int capacity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> countMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(K key) {
        Node node = nodeMap.get(key);
        if (node == null) return (int) -1;
        update(node);
        return (int) node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countMap.put(node.cnt, newList);
        }
    }
    
    private void update(Node node) {
        DLList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        if (node.cnt == min && oldList.size == 0) min++; 
        node.cnt++;
        DLList newList = countMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countMap.put(node.cnt, newList);
    }
}

 //https://leetcode.com/problems/lfu-cache/



class LFUCache {

    class Node {
        Node next; Node prev;
        int count = 1; int key; int val;
        Node (int key, int val) {
            this.key = key; this.val = val;
        }
    }
    
    class DLL {
        Node head, tail; int size = 0;
        DLL () {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        void addToHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            
            head.next = node;
            node.prev = head;
            size++;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLast() {
            if (size <= 0) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
    int capacity, size = 0, min = 0;
    Map<Integer,Node> nodeMap;
    Map<Integer,DLL> countMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update (node);
        } else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLL lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLL newList = countMap.getOrDefault(min, new DLL());
            newList.addToHead(node);
            countMap.put(min, newList);
        }
    }
    
    private void update (Node node) {
        DLL oldList = countMap.get(node.count);
        oldList.remove(node);
        if (node.count == min && oldList.size == 0) min++;
        node.count++;
        DLL newList = countMap.getOrDefault(node.count, new DLL());
        newList.addToHead(node);
        countMap.put(node.count, newList);
    }
}
