public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];
        
        int[] startFromFirstHouse = new int[nums.length + 1];
        int[] startFromSecondHouse = new int[nums.length + 1];
        
        startFromFirstHouse[0]  = 0;
        startFromFirstHouse[1]  = nums[0];
        startFromSecondHouse[0] = 0;
        startFromSecondHouse[1] = 0;
        
        for (int i = 2; i <= nums.length; i++) {
            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i-1]);
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i-1]);
        }
        
        return Math.max(startFromFirstHouse[nums.length - 1], startFromSecondHouse[nums.length]);
    }
}


//https://leetcode.com/problems/house-robber-ii/discuss/60044/Good-performance-DP-solution-using-Java
