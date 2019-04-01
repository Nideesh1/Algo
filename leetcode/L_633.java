class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a*a <= c; a++){
            double b = Math.sqrt(c - a*a);
            if(b == (int) b){
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a*a <= c; a++){
            long b = c - (int) a*a;
            if(bin(0,b,b)){
                return true;
            }
        }
        return false;
    }
    
    public boolean bin(long start, long end, long goal){
        if(start > end) return false;
        long mid = start + (end - start)/2;
        if(mid*mid == goal) return true;
        if(mid * mid > goal){
          return  bin(start, mid -1, goal);
        }
        return bin(mid+1, end, goal);
    }
}

//https://leetcode.com/problems/sum-of-square-numbers/
