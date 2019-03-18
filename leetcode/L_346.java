class MovingAverage {
    int size = 0;
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public double next(int val) { int res = 0;
        q.add(val);
        while(q.size() > size){
            q.poll();
        }
        for(Integer i : q){
            res += i;
        }
        return (double) res/q.size();                       
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 
 //https://leetcode.com/problems/moving-average-from-data-stream/
