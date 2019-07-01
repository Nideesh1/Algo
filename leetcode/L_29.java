class Solution {
    public int divide(int dividend, int divisor) {
        //System.out.println(Integer.MIN_VALUE - 1);
        //System.out.println(Integer.MAX_VALUE);
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while(a - b >= 0){
            
            int x = 0;
            while( a - (b << 1 << x) >= 0){
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return (dividend >= 0) == (divisor >= 0) ? res :-res;
    }
}

//https://leetcode.com/problems/divide-two-integers/
//https://leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int
