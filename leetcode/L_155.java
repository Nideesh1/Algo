class MinStack {
        List<Integer> l = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        l.add(x);

        stk.push(x);
    }
    
    public void pop() {
        int t = stk.peek();
        if(l.indexOf(t) != -1){
            l.remove(l.indexOf(t));
        }
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        Collections.sort(l);
        return l.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
 //each entry is gonna hold the min below itself and all nodes below it
class Node{
    int val; int min;
    public Node(int val, int min){
        this.val = val; this.min = min;
    }
}

class MinStack {
    Stack<Node> stk;
    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int x) {
        int min;
        if(stk.isEmpty() || x <= stk.peek().min){
            min = x;
        }else{
            min = stk.peek().min;
        }
        stk.push(new Node(x, min));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
       return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
 //https://leetcode.com/problems/min-stack/
