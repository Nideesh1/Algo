class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] =1;
        for (int c : coins) {
            for (int p = c; p < dp.length; p++) {
                dp[p] += dp[p - c]; 
            }
        }
        return dp[amount];
    }
}

class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0);
    }
    public int dfs(int amount, int[] coins, int start) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        String key = amount + "," + start;
        if (map.containsKey(key)) return map.get(key);
        int res = 0;
        for (int i = start; i < coins.length; i++) {
            res += dfs(amount - coins[i], coins, i);
        }
        map.put(key, res);
        return res;
    }
}

//https://leetcode.com/problems/coin-change-2/solution/
