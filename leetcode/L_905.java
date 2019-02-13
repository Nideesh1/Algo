class Solution {
    public int[] sortArrayByParity(int[] A) {
        int p = 0; int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 == 0){
                res[p] = A[i]; p++;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 != 0){
                res[p] = A[i]; p++;
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/sort-array-by-parity/description/
