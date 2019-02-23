class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '('); map.put('}', '{'); map.put(']', '[');
        char[] ar = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(char c : ar){
            if(stk.size() == 0){
                stk.push(c);
            }else{
                if(map.get(c) == stk.peek()){
                    stk.pop();
                }else{
                stk.push(c);
                }
            }
        }
        return stk.size() == 0;
    }
}

//https://leetcode.com/problems/valid-parentheses/description/
