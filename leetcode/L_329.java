class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int res  = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, cache, i, j));
            }
        }
        return res;
    }
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    
    public int dfs(int[][] matrix, int[][] cache, int i , int j){
        if(!inside(matrix, i, j)) return 0;
        if(cache[i][j] != 0) return cache[i][j];
        int ret = 0;
        for(int k = 0; k < x.length; k++){
            int ro = i + x[k]; int co = j + y[k];
            if(inside(matrix, ro, co) && matrix[i][j]< matrix[ro][co]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, ro, co));
            }
        }
        cache[i][j]++;
        return cache[i][j];
    }
    
    public boolean inside(int[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }return false;
    }
}

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
