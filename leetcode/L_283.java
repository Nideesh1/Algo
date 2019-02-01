class Solution {
    public void moveZeroes(int[] nums) {
 		int i = 0; int j = 0; int n = nums.length;
 		while(i < n && j < n){ // i is the runner, j is the placer
 			if(nums[i] != 0){nums[j] = nums[i]; i++;j++;}
 			else{
 				i++;
 			}
 		} 
 		while(j < n){nums[j] = 0; j++;}      
    }
}

//https://leetcode.com/problems/move-zeroes/description/
