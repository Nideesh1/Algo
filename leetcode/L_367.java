class Solution {
    public boolean isPerfectSquare(int num) {
        if( num == 0 || num == 1) return true;
        int i = 1; int j = num; 
        while( i <= j){
            int m = (i+j)/2;
            if(m * m == num){return true;}
            if(m >= num/m) { j = m-1; }
            if(m <= num/m) { i = m+1;}
        }
        return false;
    }
}

//https://leetcode.com/problems/valid-perfect-square/description/
