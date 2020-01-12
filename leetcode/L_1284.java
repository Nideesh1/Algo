class Solution {
    public int minFlips(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        res = dfs(mat, m, n, new HashSet<>(), new HashMap<>());
        return res == Integer.MAX_VALUE ? - 1 : res;
    }
    
    public int dfs(int[][] mat, int m , int n, Set visited, Map<String,Integer> memo){
        if(check(mat, m, n)) return 0;
        
        String state = "";
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                state += mat[i][j];
            }
        }
        
        if(memo.containsKey(state)) return memo.get(state);
        if(visited.contains(state)) return Integer.MAX_VALUE;
        
        visited.add(state);
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                
                flip(mat, i, j);
                
                int temp = dfs(mat, m, n, visited, memo);
                if(temp != Integer.MAX_VALUE) min = Math.min(min, temp + 1);
                
                flip(mat, i, j);
                
            }
        }
        
        
        visited.remove(state);
        memo.put(state, min);
        return min;
    }
    
    public boolean check(int[][] mat, int m, int n ){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1) return false;
            }
        }
        return true;
    }
    
    public void flip(int[][] mat, int i, int j){
        int m = mat.length;
        int n = mat[0].length;
        
        mat[i][j] = 1 - mat[i][j];
        for(int k  = 0; k < x.length; k++){
            int ro = i + x[k];
            int co = j + y[k];
            if(inside(mat, ro, co)){
                mat[ro][co] = 1 - mat[ro][co];
            }
        }
    }
    
    public boolean inside(int[][] mat, int i, int j){
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length ) return false;
        return true;
    }
    
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
}


//https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446371/Java-Recursion-%2B-Memoization-Explained
