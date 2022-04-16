class Solution {
    public String shortestPalindrome(String s) {
        // for finding the answer by appending the end, use StringBuider reverse3
        return dfs(s);
    }
    public String dfs (String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == s.length()) return s;
        String rem = s.substring(i);
        String rev = new StringBuilder(rem).reverse().toString();
        return rev + dfs(s.substring(0,i)) + rem;
    }
}
//https://leetcode.com/problems/shortest-palindrome/solution/
