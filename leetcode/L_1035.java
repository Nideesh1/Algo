class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        return dfs(A, B, m, n);
    }
    public int dfs(int[] A, int[] B, int m, int n){
        if(m == 0 || n == 0) return 0;
        String key = m+"-"+n;
        if(map.containsKey(key)) return map.get(key);
        if(A[m-1] == B[n-1]){
            int ret = 1 + dfs(A,B,m-1,n-1);
            map.put(key, ret);
            return ret;
            //return 1 + dfs(A, B, m-1, n-1);
        }
        int b1 = dfs(A, B, m-1, n);
        int b2 = dfs(A, B, m, n-1);
        int max = Math.max(b1, b2);
        map.put(key, max);
        return max;
    }
}


class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(A[i-1] == B[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int b1 = dp[i-1][j];
                    int b2 = dp[i][j-1];
                    dp[i][j] = Math.max(b1, b2);
                }

                
            }
        }
        
        return dp[m][n];
    }
}



