class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(!contains0(i) && !contains0(j) && ((i + j) == n)){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    public boolean contains0(int x){
        while(x != 0){
            int t = x % 10;
            if(t == 0) return true;
            x /= 10;
        }
        return false;
    }
}

