class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for(int[] o : ops){
            m = Math.min(m, o[0]);
            n = Math.min(n, o[1]);
        }
        
        return m*n;
    }
}

//https://leetcode.com/problems/range-addition-ii/
