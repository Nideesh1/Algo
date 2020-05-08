class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int n = nums.length;
        int res = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            while(!max.isEmpty() && nums[r] > max.peekLast()){
                max.pollLast();
            }
            max.add(nums[r]);
            while(!min.isEmpty() && nums[r] < min.peekLast()){
                min.pollLast();
            }
            min.add(nums[r]); 
            
            while(max.peekFirst() - min.peekFirst() > limit){
                if(nums[l] == max.peekFirst()) max.pollFirst();
                if(nums[l] == min.peekFirst()) min.pollFirst();
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/discuss/609743/Java-Detailed-Explanation-Sliding-Window-Deque-O(N)