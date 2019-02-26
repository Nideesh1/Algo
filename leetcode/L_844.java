class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stkS = new Stack<>();
        Stack<Character> stkT = new Stack<>();
        
        for(Character c : S.toCharArray()){           
            if(c == '#' && stkS.size() > 0){
                stkS.pop();
            }else if(c != '#' ){
                stkS.push(c);
            }
        }
        for(Character c : T.toCharArray()){           
            if(c == '#' && stkT.size() > 0 ){
                stkT.pop();
            }else if(c != '#' ){
                stkT.push(c);
            }
        }        
        System.out.println(stkS);
        System.out.println(stkT);        
        while(!stkS.isEmpty() && !stkT.isEmpty()){
            char s = stkS.pop(); char t = stkT.pop();
            if(s != t){return false;}
        }
        if(!stkS.isEmpty() || !stkT.isEmpty()){return false;}
        
        return true;
    }
}

//https://leetcode.com/problems/backspace-string-compare/description/
