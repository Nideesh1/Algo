class Solution {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        int left = n - 2;
        int right = n-1;
        int temp;
        while(left >= 0 && A[left] <= A[left + 1]) left--;
        if(left < 0) return A;
        
        while(A[left] <= A[right]) right--;
        while(A[right - 1] == A[right]) right--;
        
        temp = A[left];
        A[left] = A[right];
        A[right] = temp;
        
        return A;
    }
}

//https://leetcode.com/problems/previous-permutation-with-one-swap/discuss/299215/JavaC%2B%2BPython-When-Leetcode-Was-Wrong
