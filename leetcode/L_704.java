//Iterative
class Solution {
    public int search(int[] nums, int target) {
        int i = 0; int j = nums.length - 1;
        while( i <= j){
            int m = (i+j)/2;
            if(nums[m] == target){return m;}
            if(nums[m] >= target){ j = m-1;}
            if(nums[m] <= target){ i = m+1;}
        }
        return -1;
    }
}

//Recur
class Solution {
    public int search(int[] nums, int target) {
        int i = 0; int j = nums.length-1;
        return bin(nums, target, i, j);
    }
    
    public int bin(int[] nums, int target, int i, int j){
        if(i > j){return -1;}
        
        int m = (i+j)/2;
        if(nums[m] == target){return m;}
        if(target <= nums[m]){
            return bin(nums, target, i, m-1);
        }
        if(target >= nums[m]){
            return bin(nums, target, m+1, j);
        }
        return -1;
    }
}

//https://leetcode.com/problems/binary-search/description/
