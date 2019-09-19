class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        if(n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            res = s.substring(i,i+1);
        }
        int max = 1;

        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len <= n; i++){
                    int j = i + len - 1;
                
                
                    if(len <= 3){
                        if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
                    }else{
                        if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) dp[i][j] = true;
                    }
                
                    if(dp[i][j] && max < j - i + 1){
                        max = j - i + 1; res = s.substring(i,j+1);
                    }
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/longest-palindromic-substring/
