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

//https://leetcode.com/problems/implement-strstr/
