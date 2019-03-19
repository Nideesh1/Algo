class MaxStack {

    
    class Brick{
        int val; int max;
        public Brick(int val, int max){
            this.val = val;
            this.max = max;
        }
        public String toString(int val, int max){
            return val + " " + max;
        }
    }

    Stack<Brick> stk;
    /** initialize your data structure here. */
    public MaxStack() {
        stk = new Stack<>();
    }
    
    public void push(int x) {
        if(stk.isEmpty()){
            stk.push(new Brick(x,x)); return;
        }
        int max = Math.max(stk.peek().max, x);
        stk.push(new Brick(x, max));
        
    }
    
    public int pop() {
        Brick b = stk.pop();
        return b.val;
    }
    
    public int top() {
        Brick b = stk.peek();
        return b.val;
    }
    
    public int peekMax() {
        Stack<Brick> s = new Stack<>();
        while(!stk.isEmpty() && stk.peek().val != stk.peek().max){
            Brick q = stk.pop();
            s.push(q);
        }
        Brick b = stk.peek();
        while(!s.isEmpty()){
            Brick a = s.pop();
            push(a.val);
        }
        return b.val;
    }
    
    public int popMax() {
        Stack<Brick> s = new Stack<>();
        while(!stk.isEmpty() && stk.peek().val != stk.peek().max){
            Brick q = stk.pop();
            s.push(q);
            System.out.println(q.max);
        }
        Brick b = stk.pop();
        while(!s.isEmpty()){
             Brick a = s.pop();
            push(a.val);           
        }
        return b.val;
    }
    

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
 
 //https://leetcode.com/problems/max-stack/
