class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        
        for(int x : A){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        
        return Math.max(0, max - min - 2*K);
    }
}

//https://leetcode.com/problems/smallest-range-i/
