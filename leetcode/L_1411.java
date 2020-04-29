class Solution {
    public int numOfWays(int n) {
        long start121 = 6;
        long start123 = 6;
        long mod = (long) 1e9 + 7;

        long next121 = 0; 
        long next123 = 0;

        for(int i = 1; i < n; i++){
            next121 = start121 * 3 + start123 * 2;
            next123 = start121 * 2 + start123 * 2;
            start121 = next121 % mod;
            start123 = next123 % mod;
        }

        return (int) ((start121 + start123) % mod);        
    }
}

//https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574923/JavaC%2B%2BPython-DP-O(1)-Space

class Solution {
    long mod = (long) 1e9 + 7;
    public int numOfWays(int n) {
        int[][][][] dp = new int[n+1][4][4][4];
        return dfs(n, 0,0,0, dp);
    }
    
    public int dfs(int n, int colA, int colB, int colC, int[][][][] dp){
        if(n == 0) return 1;
        if(dp[n][colA][colB][colC] != 0) return dp[n][colA][colB][colC];
        
        int[] col = {1,2,3};
        
        int res = 0;
        for(int a : col){
            if(a == colA) continue;
            for(int b : col){
                if(b == colB || b == a) continue;
                for(int c : col){
                    if(c == colC || c == b) continue;
                    res += dfs(n-1, a, b, c, dp);
                    res %= mod;
                }
            }
        }
        dp[n][colA][colB][colC] = res;
        return res;
    }
}

//https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574912/JavaC%2B%2B-DFS-Memoization-with-Picture-Clean-code
