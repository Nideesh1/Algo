class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums.length == 2 && m == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 2 && m == 1) return nums[0] + nums[1];
        int lo = 0;
        for(int i : nums){
            lo = Math.max(lo, i);
        }
        int hi = 0;
        for(int i : nums) hi += i;
        
        while( lo < hi ){
            int mid = lo + (hi - lo)/2;
            
            int req = 1; int cur = 0;
            for(int i = 0; i < nums.length; i++){
                if(cur + nums[i] <= mid){
                    cur += nums[i];
                }else{
                    cur = nums[i]; req++;
                }
            }
            
            if(req <= m){hi = mid;}
            else{ lo = mid + 1;}
        }
        
        return lo;
    }
    
}
//https://leetcode.com/problems/split-array-largest-sum/
