class MyQueue {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stk2.isEmpty()){
            stk2.push(x); return;
        }
        else{
            while(!stk2.isEmpty()){
                stk1.push(stk2.pop());
            }
            stk1.push(x);
            while(!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       return stk2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stk2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 //https://leetcode.com/problems/implement-queue-using-stacks/
