class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] a = new int[nums.length];
        for(int i = 0; i < a.length; i++){a[i] = -1;}
        if(nums[0] == 1){a[0] = 1;}
        for(int i =1; i < a.length; i++){
            if(nums[i] == 0){continue;}
            if(nums[i] == 1 && nums[i-1] == 0){
                a[i] = 1;
            }
            if(nums[i] == 1 && nums[i-1] == 1){
                a[i] = a[i-1] + 1;
            }
        }
        
        int res = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] > res){res = a[i];}
        }
        
        return res;
    }
}

//https://leetcode.com/problems/max-consecutive-ones/description/
