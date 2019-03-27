class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n < 0) return false;
        
        int res = 0;
        while(n != 0){
            int t = n & 1;
            if(t == 1) res++;
            n = n >> 1;
        }
        
        return res == 1 ? true : false;
    }
}

//https://leetcode.com/problems/power-of-two/
