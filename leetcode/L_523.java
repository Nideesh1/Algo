class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = nums[i];
            for(int j = i + 1; j < n; j++){
                dp[j] = nums[j] + dp[j-1];
                if(k == 0){
                    if(dp[j] == 0){return true;}
                }
                else {if(dp[j]%k == 0){return true;}}
            }
            Arrays.fill(dp, 0);
        }
        return false;
    }
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0){
                sum = sum % k;
            }
            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1){
                    return true;
                }
            }else{
             map.put(sum, i);                
            }

        }
        return false;
    }
}

//https://leetcode.com/problems/continuous-subarray-sum/
//https://leetcode.com/problems/continuous-subarray-sum/solution/
