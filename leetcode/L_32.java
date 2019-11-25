class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stk.push(i);
            }else{
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }else{
                    res = Math.max(res, i - stk.peek());
                }
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/longest-valid-parentheses/solution/
