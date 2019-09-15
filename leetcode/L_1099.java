class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int i = 0;
        int j = A.length-1;
        Arrays.sort(A);
        int max = Integer.MIN_VALUE;
        while(i < j){
            int sum = A[i] + A[j];
            if(sum < K){
                max = Math.max(sum, max);
                i++;
            }
            if(sum >= K){
                j--;
            }

        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}


//https://leetcode.com/problems/two-sum-less-than-k/
