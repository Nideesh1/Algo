class Solution {
    public String removeOuterParentheses(String S) {
        List<Integer> l = new ArrayList<>();
        Stack<Character> stk = new Stack<>();
        char[] ar = S.toCharArray();
        for(int i = 0; i < ar.length; i++){
            if(stk.size() == 0){
                l.add(i);
                stk.push(ar[i]); continue;
            }
            if(stk.peek() == '(' && ar[i] == ')'){
                stk.pop(); if(stk.size() == 0) l.add(i);
            }else if(stk.peek() == ')' && ar[i] == '('){
                stk.pop(); if(stk.size() == 0) l.add(i);
            }else{
                stk.push(ar[i]);
            }
        }        
        System.out.println(l);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < l.size() ; i+= 2){
            sb.append(S.substring(l.get(i)+1, l.get(i+1)));
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/remove-outermost-parentheses/
