//DP
class Solution {
    public int maxProfit(int[] prices) {
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        
        for(int i : prices){
            T_ik0 = Math.max(T_ik0, T_ik1 + i);
            T_ik1 = Math.max(T_ik1, T_ik0 - i);
        }
        return T_ik0;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int pointer = 0;
        int valley = 0; int peak = 0;
        while(pointer < prices.length - 1){
            
            while(pointer < prices.length - 1 && prices[pointer] >= prices[pointer+1] ){
                pointer++;
            }
            valley = prices[pointer];
            while(pointer < prices.length - 1 && prices[pointer] <= prices[pointer+1]){
                pointer++;
            }
            peak = prices[pointer];
            profit += peak - valley;
        }
        return profit;
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
