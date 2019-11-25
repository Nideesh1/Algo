class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for(int j = n - 1; j >= 0; j--){
            if(s.charAt(i) == s.charAt(j)){
                i++;
            }
        }
        if(i == n)return s;
        String rem = s.substring(i);
        String rev = new StringBuilder(rem).reverse().toString();
        return rev + shortestPalindrome(s.substring(0,i)) + rem;
    }
}
//https://leetcode.com/problems/shortest-palindrome/solution/
