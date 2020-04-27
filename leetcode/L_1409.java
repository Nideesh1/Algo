class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] res = new int[n];
        int[] arr = new int[m];
        for(int i = 1; i <= m; i++){
            arr[i-1] = i; 
        }
        //System.out.println(Arrays.toString(arr));
        for(int i = 0; i < queries.length; i++){
            res[i] = pos(arr, queries[i]);
            //System.out.println(pos + " " + Arrays.toString(queries));
        }
        return res;
    }
    public int pos(int[] arr, int x){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(x == arr[i]){
                res = i; break;
            }
        }
        for(int i = res; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = x;
        return res;
    }
    
}
