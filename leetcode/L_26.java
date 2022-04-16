class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, write = 0;
        while (i < nums.length && j < nums.length) {
            while (nums[i] == nums[j]) {
                j++;
                if (j == nums.length) break;
            }
            nums[write++] = nums[i];
            i = j;
        }
        return write;
    }
}

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
