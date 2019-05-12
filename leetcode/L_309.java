class Solution {
    public int maxProfit(int[] prices) {
        int T_ik0_i_2 = 0;
        int T_ik0_i_1 = 0;
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        
        for(int i : prices){
            T_ik0_i_1 = T_ik0;
            T_ik0 = Math.max(T_ik0_i_1, T_ik1 + i);
            T_ik1 = Math.max(T_ik1, T_ik0_i_2 - i);
            T_ik0_i_2 = T_ik0_i_1;
        }
        return T_ik0;
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
