class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while(x != 0 || y != 0){
            int one = x & 1;
            int two = y & 1;
            if(one != two) res++;
            x = x >> 1;
            y = y >> 1;
        }
        return res;
    }
}

//https://leetcode.com/problems/hamming-distance/
