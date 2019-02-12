class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0; int r = points.length -1; int mid =0;
        while( l <= r ){
            mid = helper(points, l, r);
            if(mid <= K){ l = mid +1; }
            if(mid >= K){ r = mid -1; }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    public int helper(int[][] A, int l, int r){
        int[] pivot = A[l];
        while(l < r){
            while(l < r && compare(A[r], pivot) >= 0  ) r--;
            A[l] = A[r];
            while(l < r && compare(A[l], pivot) <= 0  ) l++;
            A[r] = A[l];            
        }
        A[l] = pivot;
        return l;
    }
    
    public int compare(int[] p1, int[] p2){
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}

//https://leetcode.com/problems/k-closest-points-to-origin/description/
