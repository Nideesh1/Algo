class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stk = new Stack<>();
        
        int num = 0;
        char sign = '+';
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1){
                
                if(sign == '+'){
                    stk.push(num);
                }
                if(sign == '-'){
                    stk.push(-num);
                }
                if(sign == '*'){
                    stk.push(stk.pop() * num);
                }
                if(sign == '/'){
                    stk.push(stk.pop() / num);
                }
                
                sign = s.charAt(i);
                num = 0;
                
            }
        }
        int res = 0;
        for(int i : stk){
            res += i;
        }
        
        return res;
    }
}

//https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
