class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int i = 0; int res = 0; int count = 1; int n = nums.length;
        while( i < n){
            while( i+1 < n && nums[i+1] > nums[i]){
                count++; i++;
            }
            res = Math.max(count, res);
            i++; count = 1;
        }
        return res;
    }
}

//https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
