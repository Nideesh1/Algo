class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        
        int i = 0; int k = K;
        while(A[i] <= 0 && k > 0){
            A[i] = -1 * A[i]; k--; i++;
            
            if(A[i] == 0){
                      int res1 = 0;
                    for(int j : A){
                        res1 += j;
                    }       
                
                return res1;
            }
            
        }
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(k);
        k = k % 2;
        if( k == 1){
            A[0] = -1 * A[0];
        }
        
        int res = 0;
        for(int j : A){
            res += j;
        }

        return res;
    }
}

/https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
