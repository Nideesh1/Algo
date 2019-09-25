class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        int j = 0;
        for(int i = 0; i < s.length() / 2; i++){
            j = s.length() - 1 - i;
            if(s.charAt(i) != s.charAt(j)){
                return rem(s, i+1, j) || rem(s, i, j - 1);
            }
        }
        return true;
    }
    
    public boolean rem(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}

//https://leetcode.com/problems/valid-palindrome-ii/description/
