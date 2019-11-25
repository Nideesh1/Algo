class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(nums == null || nums.length == 0) return 0;
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){

                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
                
            }
            
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){
                i = -(i + 1);
            }
            
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }
}

//https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(byte[],%20int,%20int,%20byte)
//https://leetcode.com/problems/longest-increasing-subsequence/solution/

