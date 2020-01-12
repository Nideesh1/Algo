class Solution {
    public int validSubarrays(int[] nums) {
        int res = nums.length;
        if(nums.length <= 1) return res;
        
        Stack<Integer> stk = new Stack<>();
        stk.push(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            while(!stk.isEmpty() && num < stk.peek() ){
                stk.pop();
            }
            res += stk.size();
            stk.push(num);
        }
        return res;
    }
}

//https://leetcode.com/problems/number-of-valid-subarrays/discuss/383716/Java-solution-with-thoughts-process
