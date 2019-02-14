class Solution {
    public boolean isMonotonic(int[] A) {
        return dec(A) || acc(A);
    }
    public boolean dec(int[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i] > a[i-1]){return false;}
        } return true;
    }
    public boolean acc(int[] a){
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){return false;}
        } return true;
    }
}

//https://leetcode.com/problems/monotonic-array/description/
