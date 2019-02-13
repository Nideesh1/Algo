class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int e = 0; int o = 1;
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 == 0){
                res[e] = A[i];
                e += 2;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 != 0){
                res[o] = A[i];
                o += 2;
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/sort-array-by-parity-ii/description/
