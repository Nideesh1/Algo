class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        qsort(A, 0, A.length-1);
        return A;
    }
    
    public void qsort(int[] A, int i, int j){
        if(i < j){
            int partIndex = part(A, i, j);
            qsort(A, i, partIndex -1);
            qsort(A, partIndex +1, j);
        }
    }
    
    public int part(int[] A, int start, int end){
        int i = start -1; int pivot = A[end];
        for(int j = start; j < end; j++){
            
            if(A[j] < pivot){
                i++;
                //swap a[i] and a[j]
                int t1 = A[i];
                A[i] = A[j];
                A[j] = t1;
            }
        }
        int t2 = A[i+1]; A[i+1] = A[end]; A[end] = t2;
        return i+1;
    }
}
//https://leetcode.com/problems/squares-of-a-sorted-array/description/
