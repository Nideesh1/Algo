class Solution {
        Stack<Integer> stk = new Stack<>();
    public int calPoints(String[] ops) {
        int res = 0;
        
        for(int i = 0; i < ops.length; i++){
            if(ops[i].equals("+")){
                int top = stk.pop();
                int newTop = top + stk.peek();
                stk.push(top);
                stk.push(newTop);
                continue;
            }            
            if(ops[i].equals("C")){
                stk.pop();
                continue;
            }
            if(ops[i].equals("D")){
                stk.push(2 * stk.peek());
                continue;
            }

            
            int t = Integer.parseInt(ops[i]);
            stk.push(t);     

        }
        
        return sum();
    }
    
    public int sum(){
        int res = 0;
        for(int i : stk){ res += i;}
        return res;
    }
}

//https://leetcode.com/problems/baseball-game/
