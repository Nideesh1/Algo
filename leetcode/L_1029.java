class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Comparator<int[]> co = new Comparator<>(){
            public int compare (int[] one, int[] two) {
                return (one[0] - one[1]) - (two[0] - two[1]);
            }
        };
        
        Arrays.sort(costs, co);
        
        int res = 0, n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        
        
        return res;
    }
}


class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + costs[i-1][0]; 
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + costs[j-1][1]; 
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + costs[i + j - 1][0], dp[i][j-1] + costs[i + j - 1][1]);
            }
        }
        
        
        return dp[n][n];
    }
}

//Credit To:https://leetcode.com/problems/two-city-scheduling/discuss/278979/Concise-Java-solution-Time%3A-O(nlogn)
//Link:https://leetcode.com/problems/two-city-scheduling/
