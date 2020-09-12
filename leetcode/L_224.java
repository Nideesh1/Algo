class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>(); int res = 0, num = 0, sign = 1;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = 10 * num + (int) c - '0';
            } else if(c == '+'){
                res += num * sign;
                sign = 1; num = 0;
            } else if(c == '-'){
                res += num * sign;
                sign = -1; num = 0;
            } else if(c == '('){
                stk.push(res); stk.push(sign);
                res = 0; sign = 1;
            } else if(c == ')'){
                res += num * sign;
                num = 0; sign = 1;
                res *= stk.pop(); res += stk.pop();
            }
        }
        if(num != 0) res += num * sign;
        return res;
    }
}
//https://leetcode.com/problems/maximum-product-subarray/discuss/48404/Accepted-Java-solution
