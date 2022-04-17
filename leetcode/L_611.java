class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int l = 0;
            int r = i-1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > nums[i]) {
                    // for a fixed i and r. We will always have valid triangles by moving the l to the right
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
