class BoundedBlockingQueue {
    Queue<Integer> q;
    int size;
    public BoundedBlockingQueue(int capacity) {
        q = new LinkedList<>();
        size = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized (this) {
            while (q.size() == size) {wait();}
            q.add(element);
            notifyAll();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int res = 0;
        synchronized (this) {
            while (q.size() == 0) {wait();}
            res = q.poll();
            notifyAll();
        }        
        return res;
    }
    
    public int size() {
        int res = 0;
        synchronized(this) {res = q.size();}
        return res;
    }
}

//https://leetcode.com/problems/design-bounded-blocking-queue/discuss/1017703/Java-Deque-%2B-Monitor-Solution
