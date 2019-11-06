class Solution {
    public void sortColors(int[] nums) {
        int one = 0;
        int two = 0; 
        int three = 0;
        for(int i : nums){
            if(i == 0)one++;
            if(i == 1)two++;
            if(i == 2)three++;
        }
        int i = 0;
        while(i < nums.length){
            while(one > 0){
                nums[i++] = 0; one--;
            }
            while(two > 0){
                nums[i++] = 1; two--;
            }
            while(three > 0){
                nums[i++] = 2; three--;
            }
            
        }
        
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int i = 0;
        while(i <= hi){
            if(nums[i] == 0) swap(nums, lo++, i++);
            else if(nums[i] == 1) i++;
            else if(nums[i] == 2) swap(nums, i, hi--);
        }
    }
    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

//https://leetcode.com/problems/sort-colors/
