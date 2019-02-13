class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length;i++){
            rev(A[i]);
        }   
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] = 1 - A[i][j];
            }
        }
        return A;
    }
    
    public void rev(int[] a){
        for(int i = 0; i < a.length/2; i++){
            int t = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = t;
        }
        return;
    }
}

//https://leetcode.com/problems/flipping-an-image/description/
