class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] m : matrix){
            if(ex(m, target)) return true;
        }
        return false;
    }
    
    public boolean ex(int[] ar, int target){
        int lo = 0;
        int hi = ar.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(ar[mid] == target)return true;
            if(target < ar[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return false;
    }
}

//https://leetcode.com/problems/search-a-2d-matrix/
