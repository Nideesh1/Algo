class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, write = 0;
        while (i < nums.length && j < nums.length) {
            while (nums[i] == nums[j]) {
                j++;
                if (j == nums.length) break;
            }
            int dif = j - i;
            dif = Math.min(2, dif);
            while (dif != 0) {
                dif--;
                nums[write++] = nums[i];
            }
            i = j;
         }
        return write;
    }
}
