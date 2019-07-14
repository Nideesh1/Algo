class NumArray {
    int[] fen; int[] arr;
    int n;
    public NumArray(int[] nums) {
        arr = nums;
        n = nums.length;
        fen = new int[n+1];
        init();
    }
    
    public void init(){
        if(n == 0) return;
        
        fen[1] = arr[0];
        for(int i = 1; i < n; i++){
            fen[i+1] = fen[i] + arr[i];
        }  
        for(int i = n; i >0 ; i--){
            int parent = i - (i & -i);
            if(parent >= 0) fen[i] -= fen[parent];
        }
        System.out.println(Arrays.toString(fen));
    }
    
    //helper
    public int sum(int i){
        int res = 0;
        while(i > 0){
            res += fen[i];
            i = i - (i & -i);
        }
        return res;
    }
    
    //helper
    public void increment(int i, int val){
        i++;
        while(i <= n){
            fen[i] += val;
            i = i + (i & -i);
        }
    }
    
    public void update(int i, int val) {
        int extra = val - arr[i];
        arr[i] = val;
        increment(i, extra);
    }
    
    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
 
 //https://leetcode.com/problems/range-sum-query-mutable/
