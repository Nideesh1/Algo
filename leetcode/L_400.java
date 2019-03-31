class Solution {
    public int findNthDigit(int n) {
        if( n < 10 ) return n;
        long x = 9;
        long i = 1;
        long y = 0;
        long totalNum = 0;
        
        while(x <= n){
            y = x;
            totalNum += 9 * (int) Math.pow(10, i-1);
            x += 9 * (int) Math.pow(10,i) * (i+1);
            i++;
        }
        
        long diff = n - y;
        long num = diff/i;
        long mod = diff%i;
        
        if(mod == 0){
            num = num + totalNum;
            return Math.toIntExact(num % 10);
        }
        
        num = num + totalNum + 1;
        long ans = 0;
        for(int j = 0; j <= i - mod; j++){
            ans = num%10;
            num /= 10;
        }
        return Math.toIntExact(ans);
    }
}

//https://leetcode.com/problems/nth-digit/
