class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return l;
        int n = matrix[0].length;

        int r1 = 0; 
        int r2 = m-1;
        int c1 = 0;
        int c2 = n-1;
        while( r1 <= r2 && c1 <= c2){
            for(int i = c1; i <= c2; i++){
                l.add(matrix[r1][i]);
            }
            for(int i = r1 + 1; i <= r2; i++){
                l.add(matrix[i][c2]);
            }         
            
            
            if(r1 < r2 && c1 < c2){
                for(int i = c2-1; i > c1; i--){
                    l.add(matrix[r2][i]);
                }            
                for(int i = r2; i > r1; i--){
                    l.add(matrix[i][c1]);
                }                
            }

            
            r1++; r2--;
            c1++; c2--;
        }
        return l;
    }
}

//https://leetcode.com/problems/spiral-matrix/solution/
