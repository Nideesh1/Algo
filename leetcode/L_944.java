class Solution {
    public int minDeletionSize(String[] A) {
        int res  = 0;
        
        for(int c = 0 ; c < A[0].length(); c++){
            for(int r = 0; r < A.length - 1; r++){
                
                if(A[r].charAt(c) > A[r+1].charAt(c)){
                    res++; break;
                }
                
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/delete-columns-to-make-sorted/
