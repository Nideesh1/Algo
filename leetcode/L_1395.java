class Solution {
    public int numTeams(int[] nums) {
        int res = 0; int n = nums.length;
        for(int j = 0; j < n; j++){

            int leftSmaller = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            int rightLarger = 0;
            
            for(int i = 0; i < j; i++){
                if(nums[i] < nums[j])  leftSmaller++; 
                if(nums[i] > nums[j]) leftLarger++;
            }
            
            for(int k = j + 1; k < n; k++){
                
                if(nums[k] < nums[j]) rightSmaller++; 
                if(nums[k] > nums[j]) rightLarger++;
            }
            
            res += leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return res;
    }
}

//https://leetcode.com/problems/count-number-of-teams/discuss/555441/JavaC%2B%2B-100-O(N2)-Easy-To-Understand-With-Explanation