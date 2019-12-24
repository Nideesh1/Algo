class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                stk.push(stk.pop() + stk.pop());
            } else if(s.equals("*")){
                stk.push(stk.pop() * stk.pop());
            } else if(s.equals("/")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a/b);
            } else if(s.equals("-")){
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a-b);
            } else{
                stk.push(Integer.valueOf(s));
            }
        }
        return stk.pop();
    }
}

//https://leetcode.com/problems/3sum/
//https://leetcode.com/problems/3sum/discuss/143636/Java-with-set
