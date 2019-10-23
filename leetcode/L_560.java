class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = nums[i];
            
            for(int j = i + 1; j < n; j++){
                dp[j] = dp[j-1] + nums[j];
            }
            for(int l = i; l < dp.length; l++){
                if(dp[l] == k){res++;}
            }
            Arrays.fill(dp,0);
        }
        return res;
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //for individual elements
        int res = 0;
        int cumSum = 0;
        for(int i : nums){
            cumSum += i;
            
            if(map.containsKey(cumSum - k)){
                res += map.get(cumSum - k);
            }
            
            map.put(cumSum, map.getOrDefault(cumSum,0) + 1);
        }
        return res;
    }
}

//https://leetcode.com/problems/subarray-sum-equals-k/submissions/
//https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
