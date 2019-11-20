class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int operand = 0;
        int sign = 1;
        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                operand = operand * 10 + (int) (c - '0');
            }
            else if(c == '+'){
                result += sign * operand;
                sign = 1;
                operand = 0;
            }
            else if(c == '-'){
                result += sign * operand;
                sign = -1;
                operand = 0;
            }
            else if(c == '('){
                stk.push(result);
                stk.push(sign);
                
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += sign * operand;
                
                result *= stk.pop();
                result += stk.pop();
                
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}

//https://leetcode.com/problems/basic-calculator/solution/
