class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColZero = false;
        
        //check if first column needs to be zero
        //if i,j is zero, then set the first row and col in that combo to 0
        for(int i = 0; i < m; i++){           
            if(matrix[i][0] == 0){
                firstColZero = true;
            }          
            for(int j = 1; j < n; j++){               
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }             
            }
        }
        
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        
        if(matrix[0][0] == 0){
            for(int j = 0; j < n ; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(firstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
        
    }
}

//https://leetcode.com/problems/set-matrix-zeroes/
