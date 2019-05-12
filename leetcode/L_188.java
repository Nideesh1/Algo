class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //degenrates to k is infinite
        if(k >= n/2){
            int T_ik0 = 0;
            int T_ik1 = Integer.MIN_VALUE;
            
            for(int i : prices){
                T_ik0 = Math.max(T_ik0, T_ik1 + i);
                T_ik1 = Math.max(T_ik1, T_ik0 - i);
            }
            return T_ik0;
        }
        
        
        int[] T_ik0 = new int[k+1];
        int[] T_ik1 = new int[k+1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);
        
        for(int i : prices){
            for(int j = k; j > 0; j--){
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + i);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j-1] - i);
            }
        }
        return T_ik0[k];
        
    }
}
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
//Solution https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
