class Solution {
    public boolean checkPossibility(int[] nums) {
        //Modification can mean anything. Since the condition is <= we are going to cleverly
        //set nums[i]s equal to each other
        int count = 0;
        for(int i = 1; i < nums.length && count <= 1; i++){
            
            if(nums[i-1] > nums[i]){
                
                count++;
                if( (i - 2 < 0) || nums[i-2] <= nums[i] )
                {
                    nums[i-1] = nums[i];
                }else{
                    nums[i] = nums[i-1];
                }
                
            }
            
        }
        
        return count <= 1;
        
    }
}

//https://leetcode.com/problems/non-decreasing-array/description/
