class Solution {
    public int longestArithSeqLength(int[] A) {
        //minimum of this answer is 2
        int res = 2; 
        int n = A.length;
        //key of dp[i] is the difference between A[i] and A[j] where
        // i > j. Value of dp[i] is the length of the longest arithmetic 
        //seq ending at A[i]
        Map<Integer,Integer>[] dp = new HashMap[n];
        
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                int dif = A[i] - A[j];
                dp[i].put(dif, dp[j].getOrDefault(dif, 1)+1);
                res = Math.max(res, dp[i].get(dif));
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/longest-arithmetic-sequence/
//https://leetcode.com/problems/longest-arithmetic-sequence/discuss/274611/JavaC%2B%2BPython-DP
