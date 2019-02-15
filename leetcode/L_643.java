//important sliding window

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        double res = Integer.MIN_VALUE;
        res = Math.max(res,sum);
        for(int i = k ; i < nums.length; i++){
            sum = sum + nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res/k;
    }
}

//https://leetcode.com/problems/maximum-average-subarray-i/description/
