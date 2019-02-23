class Solution {
    public boolean validPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++){
            
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                int j = s.length() - 1- i;
                return palindromeRange(s, i, j-1) || palindromeRange(s, i+1, j);
            }
            
        }
        return true;
    }
    
    public boolean palindromeRange(String s, int i , int j){
        for(int k = i; k <= i + (j-i)/2; k++){
            if(s.charAt(k) != s.charAt(j + i - k)){
                return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/problems/valid-palindrome-ii/description/
