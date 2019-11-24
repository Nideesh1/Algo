class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return true;
            //means nums[start] to nums[mid] sorted
            if(nums[start] < nums[mid]){
                
                //check if target in left half
                if(nums[start] <= target && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            //means nums[mid] to nums[end] sorted
            }else if(nums[mid] < nums[start]){
                
                if(nums[mid] < target && target < nums[start]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
                
            }else{
                start++;
            }
        }
        return false;
    }
}


//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28216/Java-1ms-binary-search-solution-with-comments
