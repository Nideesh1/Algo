class Solution {
    public int arrangeCoins(int n) {
        // basically asking 1+2+3...k >= n
        // x(x+1)/2 >= n. what's the x?
        long nlong = (long) n;
        long i = 0;
        long j = nlong;
        long mid = 0;
        while( i <= j){
            long m = i + (j-i)/2;
            if( m * (m+1) >= 2 * nlong){   j = m-1; }
            if( m * (m+1) <= 2 *nlong){ i = m+1;}
        }
        return (int) i-1;
    }
}

//https://leetcode.com/problems/arranging-coins/description/
