class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            min.add(num);
            max.add(min.poll());
        }else{
            max.add(num);
            min.add(max.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (min.peek() + max.peek()) / 2.0;
        }else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
 //https://leetcode.com/problems/find-median-from-data-stream/solution/
