class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int each = Math.max(0, dq.isEmpty() ? 0 : dp[dq.peekFirst()]);
            dp[i] = nums[i] + each;
            res = Math.max(res, dp[i]);
            
            while(!dq.isEmpty() && dp[i] >= dp[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            while(i - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/constrained-subsequence-sum/discuss/605822/Java-Decreasing-Monotonic-Queue-Clean-code-O(N)