class MyCircularQueue {

    class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    
    
    Node head, tail;
    int count;
    int capacity;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.count == capacity){
            return false;
        }
        Node nn = new Node(value);
        if(this.count == 0){
            head = tail = nn;
        }else{
            tail.next = nn;
            tail = nn;
        }
        this.count++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.count == 0){
            return false;
        }
        this.head = head.next;
        this.count--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(this.count == 0){
            return -1;
        }else return head.value;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count == 0){
            return -1;
        }else return tail.value;        
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.capacity == count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 
 //https://leetcode.com/problems/design-circular-queue/solution/
