//Stack
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
//Two pointer
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1; int skipS = 0;
        int j = T.length() - 1; int skipT = 0;
        
        while(i >= 0 || j >= 0){
            
            
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    skipS++; i--;
                }
                else if(skipS > 0){
                    skipS--; i--;
                }
                else break;
            }
            while(j >= 0){
                if(T.charAt(j) == '#'){
                    skipT++; j--;
                }
                else if(skipT > 0){
                    skipT--; j--;
                }
                else break;
            }
            
            if( i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                return false;
            }
            if( (i >= 0) != (j >= 0)){
                return false;
            }
            i--; j--;
        }
        return true;
    }
}


//https://leetcode.com/problems/backspace-string-compare/description/
