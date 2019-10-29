class Solution {
    int n = 0;
    public void nextPermutation(int[] nums) {
        n = nums.length;
        
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n-1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    public void reverse(int[] nums, int start){
        int lo = start; int hi = n-1;
        while(lo <= hi){
            swap(nums, lo, hi); lo++; hi--;
        }
    }
    
    
    public void swap(int[] ar, int i, int j){
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
}

//https://leetcode.com/problems/next-permutation/solution/
//https://leetcode.com/problems/next-permutation/
