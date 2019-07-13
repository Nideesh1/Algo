class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            int each = x%10;
            x /=10;
            if((res > Integer.MAX_VALUE/10) || (res == Integer.MAX_VALUE/10 && each > 7))return 0;
            if((res < Integer.MIN_VALUE/10) || (res == Integer.MIN_VALUE/10 && each < -8))return 0;
            res = res * 10 + each;
        }
        return res;
    }
}

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop == 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop == -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

//https://leetcode.com/problems/reverse-integer/
