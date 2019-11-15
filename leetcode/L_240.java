class Solution {
    
    int[][] mat;
    int tar;
    public boolean searchMatrix(int[][] matrix, int target) {
        mat = matrix;
        tar = target;
        if(mat == null || mat.length == 0) return false;
        return dfs(0,0, mat[0].length - 1, mat.length - 1);
    }
    
    public boolean dfs(int left, int up, int right, int down){
        if( left > right || up > down) return false;
        else if(tar > mat[down][right] || tar < mat[up][left]){
            return false;
        }
        
        int row = up;
        int mid = left + (right - left)/2;
        while( row <= down && mat[row][mid] <= tar){
            if(mat[row][mid] == tar)return true;
            row++;
        }
        
        return dfs(left, row, mid-1, down) || dfs(mid + 1, up, right, row - 1);
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){
                row--;
            }else if(matrix[row][col] < target){
                col++;
            }
            else if(matrix[row][col] == target){
                return true;
            }
        }
        return false;
    }
}

//https://leetcode.com/problems/search-a-2d-matrix-ii/solution/

