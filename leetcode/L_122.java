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
