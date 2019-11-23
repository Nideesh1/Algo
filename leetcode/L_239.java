class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n * k == 0) return new int[0];
        if(k == 1) return nums;
        
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        
        for(int i = 1; i < nums.length; i++){
            
            if(i % k == 0) left[i] = nums[i];
            else{
                left[i] = Math.max(left[i-1], nums[i]);
            }
            
            int j = n - 1 - i;
            if((j+1) % k == 0) right[j] = nums[j];
            else{
                right[j] = Math.max(nums[j], right[j+1]);
            }
        
        }
        
        int[] out = new int[n - k + 1];
        for(int i = 0; i < out.length; i++){
            out[i] = Math.max(right[i], left[i + k - 1]);
        }

        return out;        
        
    }
}

//https://leetcode.com/problems/sliding-window-maximum/solution/
