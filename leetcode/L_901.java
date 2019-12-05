class StockSpanner {
    Stack<int[]> stk = new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int res = 1;
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            res += stk.pop()[1];
        }
        stk.push(new int[]{price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
 
 //https://leetcode.com/problems/online-stock-span/discuss/168311/C%2B%2BJavaPython-O(1)
