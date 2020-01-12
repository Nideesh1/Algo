class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                mat[i][j] += mat[i][j-1];
            }
        }
        
        
        int res = 0;
        for(int i= 0; i < n; i++){
            for(int j = i; j < n; j++){
                
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int temp = 0;
                
                for(int k = 0; k < m; k++){
                    
                    temp += mat[k][j] - (i > 0 ? mat[k][i-1] : 0);
                    res += map.getOrDefault(temp - target, 0);
                    
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
                
            }
        }
        
        return res;
    }
}

//https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/303750/JavaC%2B%2BPython-Find-the-Subarray-with-Target-Sum
