class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int x = coin; x < amount + 1; x++){
                dp[x] += dp[x - coin];
        //        System.out.println(Arrays.toString(dp));
            }
        }

        return dp[amount];
    }
}

//https://leetcode.com/problems/coin-change-2/solution/
