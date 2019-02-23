class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){return "";}
        if(strs.length == 1){return strs[0];}
        
        String w = strs[0];
        for(int i = 1; i < strs.length; i++){
            w = com(w, strs[i]);
        }
        return w;
    }
    
    public String com(String s1, String s2){
        int i = 0; int j = 0;
        StringBuilder sb = new StringBuilder();
        while( i < s1.length() && j < s2.length())  {
            
            while(s1.charAt(i) == s2.charAt(j)){
                sb.append(s1.charAt(i));
                i++; j++;
                if( i == s1.length())break ;
                if( j == s2.length())break ;
            }
            break;
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/longest-common-prefix/description/
