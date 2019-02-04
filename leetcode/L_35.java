class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0; int j = nums.length-1;
        while(i <= j){
            int m = (i+j)/2;
            if(nums[m] == target){return m;}
            if(nums[m] >= target){ j = m-1;}
            if(nums[m] <= target){ i = m+1;}
        }
        return i;
    }
}

//https://leetcode.com/problems/search-insert-position/description/
