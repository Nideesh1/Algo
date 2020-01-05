class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int p = 0;
        for(int[] q : queries){
            res[p++] = xor(arr, q[0], q[1]);
        }
        return res;
    }
    
    public int xor(int[] arr , int i, int j){
        int res = 0;
        for(int k = i; k <= j; k++){
            res ^= arr[k];
        }
        return res;
    }
}
