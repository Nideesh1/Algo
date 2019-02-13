class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for(int i = 0; i < queries.length; i++){
            int ind = queries[i][1];
            int val = queries[i][0];
            A[ind] += val;
            res[i] = eSum(A);
        }
        return res;
    }
    public int eSum(int[] a){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] %2 == 0){
                count += a[i];
            }
        }
        return count;
    }
}
//https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/
