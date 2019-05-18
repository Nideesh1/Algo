class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean firstExists = false;
        for(int i : nums){
            if(i == 1) firstExists = true;
        }
        if(!firstExists) return 1;
        if(n == 1) return 2;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        
        for(int i = 0; i < nums.length; i++){
            int v = Math.abs(nums[i]);
            //So we don't go out of bounds
            if(v == n){
                nums[0] = -1 * Math.abs(nums[0]);
            }else{
                nums[v] = -1 * Math.abs(nums[v]);
            }
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0) return i;
        }
        if(nums[0] > 0) return n;
        return n+1;
    }
}

//https://leetcode.com/problems/first-missing-positive/
//https://leetcode.com/problems/first-missing-positive/solution/
