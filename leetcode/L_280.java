class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            //if i is odd and smaller than previous, swap
            if(i%2 == 1){
                if(nums[i] < nums[i-1]){
                    swap(nums, i);
                }
            } else if(i != 0 && nums[i] > nums[i-1]){
                    swap(nums, i);   
            }
            
        }
    }
    
    public void swap(int[] nums, int i){
        int t = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = t;
    }
}

//https://leetcode.com/problems/wiggle-sort/
