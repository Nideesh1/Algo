//Even better
class Solution {
    public int maxProfit(int[] prices) {
        int T_i10 = 0; 
        int T_i11 = Integer.MIN_VALUE;
        
        for(int i : prices){
            T_i10 = Math.max(T_i10, T_i11 + i);
            T_i11 = Math.max(T_i11, 0 - i); // 0 is equal to T_i00
        }
        return T_i10;
    }
}

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
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
