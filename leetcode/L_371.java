class Solution {
    public int getSum(int x, int y) {
        int carry = 0;
        
        while(y != 0){
            carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
}

//https://leetcode.com/problems/sum-of-two-integers/
