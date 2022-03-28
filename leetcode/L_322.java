class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount);
    }
    public int dfs(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (map.containsKey(amount)) return map.get(amount);
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int num = dfs(coins, amount - c);
            if (num == -1) continue;
            min = Math.min(min, dfs(coins, amount - c));
        }
        //System.out.println(min);
        min = min == Integer.MAX_VALUE ? -1 : min + 1;
        map.put(amount, min);
        return min;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0 && dp[i-c] != -1) {
                    min = Math.min(min, dp[i-c]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        
        return dp[amount];
    }
}
