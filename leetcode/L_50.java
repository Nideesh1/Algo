class Solution {
    public double myPow(double x, int n) {
        double res  = 1;
        long absN = Math.abs( (long) n);
        
        while(absN > 0){
            if((absN & 1) == 1){
                res = res * x;
            }
            absN = absN >> 1;
            x = x * x;
        } 
        return n < 0 ? 1/res : res;
    }
}

//N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
//x^9 = x^(2^3) * x^(2^0)
//https://leetcode.com/problems/powx-n/discuss/19563/Iterative-Log(N)-solution-with-Clear-Explanation
