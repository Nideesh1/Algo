//KMP Algo

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))return 0;
        int n = haystack.length();
        int m = needle.length();
        int[] lps = new int[m];
        lps(needle, lps);
        
        int j = 0;//pointer for needle
        int i = 0;//pointer for haystack
        
        while(i < n){
            
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
            }
            if(m == j){
                return i - j;
            }
            else if(i < n && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
                
            }
            
        }
        return -1;
    }
    
    public void lps(String needle, int[] lps){
        int m = lps.length;
        int len = 0;//slow runner
        int i = 1;//fast runner
        lps[0] = 0;//this is always 0
        while(i < m){
            if(needle.charAt(i) == needle.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    lps[i] = len;
                    i++;
                }else{
                    len = lps[len-1];
                    
                }
            }
        }
    }
}


//Rabin Karp
class Solution {
    
    
        int R = 256;
        int Q = 997;
    
    public int strStr(String haystack, String needle) {
        int m = needle.length(); 
        int n = haystack.length();
        
        if ( needle.length() > haystack.length() ) { return -1; }
        if ( needle.length() == 0 ) { return 0; }
        
        long nhash = hash(needle, m);
        long hhash = hash(haystack, m);
        
        if(nhash == hhash) return 0;
        //System.out.println(nhash);
        //System.out.println(hhash);
        int RM = 1;
        for(int i = 1; i <= m - 1; i++){
            RM = ((RM * R)) % Q;
        }
        
        for(int i = m ; i < n; i++){
            hhash = (hhash + Q - RM*haystack.charAt(i - m) % Q) % Q;
            hhash = (hhash*R + haystack.charAt(i)) % Q;
            
            if(hhash == nhash && haystack.substring(i - m +1 ,  i + 1).equals(needle)) {
                //System.out.println(haystack.substring(i - m +1 ,  i + 1));
                return i - m + 1;
            }
            // if ( hhash == nhash && haystack.substring(i - m -1, i +1).equals(needle) ) {
            //     return i - m + 1;
            // }
        }
        
        return -1;
    }
    
    public long hash(String str, int m){
        long hash = 0;
        for(int i = 0; i < m; i++){
            hash = (hash * R + str.charAt(i)) % Q;
        }
        return hash;
    }
}
//https://leetcode.com/problems/implement-strstr/
