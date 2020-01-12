class FreqStack {

    Map<Integer,Integer> freq = new HashMap<>();
    Map<Integer,Stack<Integer>> map = new HashMap<>();
    int mf = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        
        mf = Math.max(mf, f);
        
        Stack<Integer> stk = map.getOrDefault(f, new Stack<>());
        stk.push(x);
        map.put(f, stk);
    }
    
    public int pop() {
        int x = map.get(mf).pop();
        freq.put(x, mf - 1);
        
        if(map.get(mf).size() == 0) mf--;
        return x;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
 
 //https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
