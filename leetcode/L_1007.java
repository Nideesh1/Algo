class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rot = check(A[0], B, A, n);
        
        if(rot != -1 || A[0] == B[0]) return rot;
        else return check(B[0], A, B, n);
        
    }
    
    public int check(int x , int[] A, int[] B, int n){
        int res = 0;
        int rot_a = 0;
        int rot_b = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != x && B[i] != x) return -1;
            else if(A[i] != x) rot_a++;
            else if(B[i] != x) rot_b++;
        }
        return Math.min(rot_a, rot_b);
    }
}

//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/solution/
