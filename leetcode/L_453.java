class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length -1; i > 0; i--){
            count += nums[i] - nums[0];
        }
        return count;
    }
}

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
