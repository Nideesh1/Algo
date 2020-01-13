class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean oneExist = false;
        for(int o : nums){
            if(o == 1) oneExist = true;
        }
        if(!oneExist) return 1;
        
        //making sure we will never see a number in the 
        //array apart from 1...n
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        
        for(int i = 0; i < nums.length; i++){
            int v = Math.abs(nums[i]);
            
            
            //simply invalidating an index v and it's content
            //because we found a value v
            if(v == n){
                nums[0] = -1 * Math.abs(nums[0]);
            }else{
                nums[v] = -1* Math.abs(nums[v]);
            }
        }
        
        for(int i = 1; i < n; i++){
            if(nums[i] > 0) return i;
        }
        
        if(nums[0] > 0) return n;
        return n + 1;
    }
}

//https://leetcode.com/problems/first-missing-positive/
//https://leetcode.com/problems/first-missing-positive/solution/
