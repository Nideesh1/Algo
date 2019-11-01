class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        char[] ar = num.toCharArray();
        for(char c : ar){
            while(!stk.isEmpty() && k > 0 && stk.peek() > c){
                stk.pop(); k--;
            }
            stk.push(c);
        }
        
        while(k != 0){
            stk.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        boolean zeroStart = true;
        for(char c : stk){
            if(zeroStart && c == '0'){continue;}
            zeroStart = false;
            res.append(c);
        }
        
        return res.length() == 0 ? "0" : res.toString();
    }
}


//https://leetcode.com/problems/remove-k-digits/
//https://leetcode.com/problems/remove-k-digits/solution/
