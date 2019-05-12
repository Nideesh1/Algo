class Solution {
    public int maxProfit(int[] prices) {
        int T_i20 = 0;
        int T_i21 = Integer.MIN_VALUE;
        int T_i10 = 0;
        int T_i11 = Integer.MIN_VALUE;
        
        for(int i : prices){
            T_i20 = Math.max( T_i20, T_i21 + i );
            T_i21 = Math.max( T_i21, T_i10 - i );
            T_i10 = Math.max( T_i10, T_i11 + i );
            T_i11 = Math.max( T_i11, -i);
        }
        return T_i20;
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//Solution:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
