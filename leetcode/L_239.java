class Solution {
    Deque<Integer> dq;
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        
        dq = new ArrayDeque(); this.nums = nums;
        
        int max_idx = 0;
        for(int i = 0; i < k; i++){
            cleanDQ(i, k); 
            if(nums[i] > nums[max_idx]) max_idx = i;
        }
        
        res[0] = nums[max_idx];
        int p = 1;
        for(int i = k; i < n; i++){
            cleanDQ(i, k); 
            
            
            res[p++] = nums[dq.getFirst()];
        }
        
        return res;
    }
    
    public void cleanDQ(int i, int k){
        //making sure we don't have indices in the DQ
        //which is out of window bounds
        if(!dq.isEmpty() && i - k >= dq.getFirst()){
            dq.pollFirst();
        }
        
        //new numbers always come from the end of the DQ. 
        //WHY?
        //because we are goign into the array from left to right
        //The new numbers always want to be the biggest. 
        //So they remove everything they see
        while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
            dq.pollLast();
        }
        
        //The new big nu
        dq.addLast(i);
    }
}

//https://leetcode.com/problems/sliding-window-maximum/solution/
