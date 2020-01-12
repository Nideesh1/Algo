class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i = n - 1; i >= 2; i--){
            
            int lo = 0;
            int hi = i - 1;
            
            while(lo < hi){
                
                int sum = nums[lo] + nums[hi];
                if(sum > nums[i]){
                    res += hi - lo;
                    hi--;
                }else{
                    lo++;
                }
                
            }
            
        }
        return res;
    }
}
//https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
