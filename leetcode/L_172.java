class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int p = 1;
        while(n >= Math.pow(5,p)){
            ans += n / Math.pow(5,p);
            p++;
        }
        return ans;
    }
}

//https://leetcode.com/problems/factorial-trailing-zeroes/
