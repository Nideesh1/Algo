class Solution {
    public int numberOfArithmeticSlices(int[] A) { int n = A.length;
        int[] dp = new int[n];
         int sum = 0;                                         
        for(int i = 2; i < n; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1] + 1;
            }
            sum += dp[i];
        }                     
        return sum;                                          
    }
}

public class Solution {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }
    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else {
            slices(A, i - 1);
        }
        return ap;
    }
}

//https://leetcode.com/problems/arithmetic-slices/
//Solution Tab: https://leetcode.com/problems/arithmetic-slices/solution/
