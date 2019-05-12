class Solution {
    public int maxProfit(int[] prices, int fee) {
        long T_ik0_1  = 0;
        long T_ik0  = 0;
        long T_ik1= Integer.MIN_VALUE;
        
        for(int i : prices){
            T_ik0_1 = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + i - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_1 - i);
        }
        return (int) T_ik0;
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
