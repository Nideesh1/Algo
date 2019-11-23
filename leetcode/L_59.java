class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n-1;
        int bot = n-1;
        int num = 1;
        while(left <= right && top <= bot){
            for(int j = left; j <= right; j++){
                res[top][j] = num++;
            }
            top++;
            
            for(int i = top; i <= bot; i++){
                res[i][right] = num++;
            }
            right--;
            
            for(int j = right; j >= left; j--){
                res[bot][j] = num++;
            }
            bot--;
            
            for(int i = bot; i >= top; i--){
                res[i][left]= num++;
            }
            left++;
        }
        
        return res;
    }
}

//https://leetcode.com/problems/spiral-matrix-ii/discuss/22289/My-Super-Simple-Solution.-Can-be-used-for-both-Spiral-Matrix-I-and-II
