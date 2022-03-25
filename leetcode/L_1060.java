class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 1, right = nums.length;
        int target = nums[0] + k;
        
        while (left < right) {
            int m = (left + right ) / 2;
            if (nums[m] <= target + m - 1) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        
        return target + left -1;
    }
}
