class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 0) return false;
        int pos = 0;
        int res = 0;
        while(num != 0){
            int t = num & 1;
            if((pos%2 == 0)  && t == 1){
                res++;
            }
            if((pos%2 == 1)  && t == 1){
                return false;
            }            
            num >>= 1;
            pos++;
        }
        return res == 1? true: false;
    }
}

//https://leetcode.com/problems/power-of-four/
