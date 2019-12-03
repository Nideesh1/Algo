class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(mid %2 == 1)mid--;
            if(nums[mid] == nums[mid+1]){
                lo = mid + 2;
            }else{
                hi = mid;
            }
        }
        return nums[lo];
    }
}

//https://leetcode.com/problems/single-element-in-a-sorted-array/solution/
