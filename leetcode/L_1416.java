class Solution {
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        long mod = (long) 1e9 + 7;

        for(int i = s.length() - 1; i >= 0; i--){
        	if(s.charAt(i) == '0') continue;
        	long num = 0;
        	//the <= is because the base case is tucked in dp[s.length()]
        	for(int size = 1; i + size <= s.length(); size++){
        		num = num * 10 + (s.charAt(i + size - 1) - '0');
        		if(num > k) break;
        		dp[i] += dp[i + size];
        		dp[i] %= mod;
        	}

        }

        return dp[0];
    }
}

class Solution {
    long mod = (long) 1e9 + 7;
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        dfs(s, k, 0, dp);
        return dp[0];
    }

    public int dfs(String s, int k, int p, int[] dp){
        if(p == s.length()) return 1;
        if(dp[p] != 0) return dp[p];
        if(s.charAt(p) == '0') return 0;
        int ans = 0;
        long num = 0;
        for(int i = p; i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num > k) break;
            ans += dfs(s, k, i + 1, dp);
            ans %= mod;
        }
        dp[p] = ans;
        return ans;
    }
}

//https://leetcode.com/problems/restore-the-array/discuss/585552/JavaC%2B%2B-DFS-Memoization-Clean-code
//https://leetcode.com/problems/restore-the-array/discuss/585597/C%2B%2BJava%3A-3-Approaches