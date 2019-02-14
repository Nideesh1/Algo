class Solution {
    public int missingNumber(int[] nums) {
        int tot = (nums.length)*(nums.length + 1)/2;
        int sum = 0;
        for(Integer i : nums){sum += i;}
        return tot - sum;
    }
}

//https://leetcode.com/problems/missing-number/description/
