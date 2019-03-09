class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        for(int i = 0; i < prices.length ;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                first = i;
            }else if(max < prices[i] - minPrice){
                max = prices[i] - minPrice;
                second = i;
            }
        }
        System.out.println(first);
        System.out.println(second);
        return max;
    }
}


//O(n^2)
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length ;j++ ){
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
