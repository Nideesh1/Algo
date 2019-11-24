class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0) return 0;
        int[] dp = new int[matrix[0].length];
        int res = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
                
            }
            
            res = Math.max(res, maxstk(dp));
        }
        
        return res;
    }
   
    
    public int maxstk(int[] dp){
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            while(stk.peek() != -1 && dp[stk.peek()] >= dp[i]){
                res = Math.max(res, dp[stk.pop()] * (i - stk.peek() - 1));
            }
            stk.push(i);
        }
        while(stk.peek() != -1){
            res = Math.max(res, dp[stk.pop()] * (dp.length - stk.peek() - 1));
        }
        
        return res;
    }
    
//     public int maxrec(int[] dp){
//         return dfs(dp, 0, dp.length - 1);
//     }
    
//     public int dfs(int[] dp, int l, int r){
//         if(l > r) return 0;
//         int minInd = l;
//         for(int i = l; i <= r; i++){
//             if(dp[i] < dp[minInd]){
//                 minInd = i;
//             }
//         }
        
//         int left = dfs(dp, l, minInd - 1);
//         int right = dfs(dp, minInd + 1, r);
//         return Math.max(dp[minInd] * (r - l + 1), Math.max(left, right));
//     }
}

//https://leetcode.com/problems/maximal-rectangle/
//https://leetcode.com/problems/maximal-rectangle/solution/
