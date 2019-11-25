class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        
        if(ns > nt){
            return isOneEditDistance(t, s);
        }
        
        for(int i = 0; i < ns; i++){
            if(s.charAt(i) != t.charAt(i)){
                
                //if same length
                if(ns == nt){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    return s.substring(i).equals(t.substring(i+1));
                }
                
            }
        }
        
        return ns + 1 == nt;
    }
}
//https://leetcode.com/problems/one-edit-distance/solution/
