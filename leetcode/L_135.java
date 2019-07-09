class Solution {
    int[] ar;
    public int candy(int[] ratings) {
        int res = 0;
        ar = ratings;
        int n = ratings.length;
        if(n == 1) return 1;
        int[] dp = new int[n]; Arrays.fill(dp,1);

        for(int i = 1; i < n-1; i++){
            int l = 0; int r = 0; 
            if(ar[i] > ar[i-1]) l = dp[i-1];
            if(ar[i] > ar[i+1]) r = dp[i+1];
            dp[i] = Math.max(l,r) + 1;
            //System.out.println("i is " + i + " " + Arrays.toString(dp));
        }
        for(int i = 1; i < n; i++){
            if(ar[i] > ar[i-1]){
                while(dp[i] <= dp[i-1]){
                    dp[i]++;
                }
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(ar[i] > ar[i+1]){
                while(dp[i] <= dp[i+1]){
                    dp[i]++;
                }
            }
        }
         System.out.println( Arrays.toString(dp));
        for(int i : dp) res += i;
        return res;
    }
}
//https://leetcode.com/problems/candy/
