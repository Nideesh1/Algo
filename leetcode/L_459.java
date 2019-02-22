class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        char[] ar = s.toCharArray();
        
        for(int i = 0; i < ar.length; i++){
            
            sb.append(ar[i]);
            String t = sb.toString();
            if(t.length() == s.length()){return false;}
            if(match(t, s)){
                return true;
            }
            
        }
        
        return false;
        
    }
    
    public boolean match( String t, String s){
        StringBuilder sb = new StringBuilder(t);
        while(sb.length() <= s.length()){
            if(sb.toString().equals(s)){return true;}
            sb.append(t);
        }
        return false;
    }
}

//https://leetcode.com/problems/repeated-substring-pattern/description/
