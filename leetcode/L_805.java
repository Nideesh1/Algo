class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int n = A.length;
        if(n == 1) return false;
        int sumA = 0;
        for(int a : A) sumA += a;
        Arrays.sort(A);
        for(int lenB = 1; lenB <= n /2; lenB++){
            if((sumA*lenB) % n == 0){
                if(dfs(A, (sumA * lenB)/n , lenB, 0)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int[] A, int leftSum, int leftNum, int start){
        if(leftNum == 0) return leftSum == 0;
        if(A[start] > leftSum / leftNum) return false;
        
        for(int i = start; i < A.length - leftNum + 1; i++){
            if(i > start && A[i] == A[i-1]) continue;
            if(dfs(A, leftSum - A[i], leftNum - 1, i + 1)){return true;}
        }
        return false;
    }
}

//https://leetcode.com/problems/split-array-with-same-average/solution/
