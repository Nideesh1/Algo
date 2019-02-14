class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length; int n = nums[0].length;
        if(m*n != r*c){return nums;}
        
        int[][] res = new int[r][c];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                q.add(nums[i][j]);
            }
        }
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                res[i][j] = q.poll();
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/reshape-the-matrix/description/
