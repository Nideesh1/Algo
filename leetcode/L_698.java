class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % k != 0 || maxNum > sum / k) {
            return false;
        }
        return canPartitionKSubsetsFrom(nums, k, new boolean[nums.length], sum / k, 0, 0);
    }
    
    private boolean canPartitionKSubsetsFrom(int[] nums, 
                                             int k,
                                             boolean[] visited, 
                                             int targetSubsetSum, 
                                             int curSubsetSum, 
                                             int nextIndexToCheck) {
        if (k == 0) {
            return true;
        }
        
        if (curSubsetSum == targetSubsetSum) {
            return canPartitionKSubsetsFrom(nums, 
                                            k - 1,
                                            visited,
                                            targetSubsetSum,
                                            0,
                                            0);
        }
        
        for (int i = nextIndexToCheck; i < nums.length; i++) {
            if (!visited[i] && curSubsetSum + nums[i] <= targetSubsetSum) {
                visited[i] = true;
                if (canPartitionKSubsetsFrom(nums, 
                                             k,
                                             visited,
                                             targetSubsetSum,
                                             curSubsetSum + nums[i],
                                             i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
}

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/discuss/180014/Backtracking-Thinking-Process
