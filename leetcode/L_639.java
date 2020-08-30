class Solution {
    private static final long M = (long) 1e9 + 7;
    // function of addition with mod
    private long add(long num1, long num2) {
        return (num1 % M + num2 % M) % M;
    }
    // how many ways to decode using one char
    private long ways(char a) {
        return (a == '*') ? 9 : (a != '0') ? 1 : 0; // simple way to write if else statement
    }
    // how many ways to decode using two chars
    private long ways(char a, char b) {
        if (a == '*' && b == '*') { // "**" neither is digit
            return 15;
        } else if (a == '*') {      // "*D" snd is a digit
            return (b > '6') ? 1 : 2;
        } else if (b == '*') {      // "D*" fst is a digit
            return (a == '1') ? 9 : (a == '2') ? 6 : 0;
        } else {                    // "DD" both r digits
            int val = Integer.valueOf("" + a + b);
            return (10 <= val && val <= 26) ? 1 : 0;
        }
    } 
    
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1]; // use long to prevent overflow
        dp[0] = 1;
        dp[1] = ways(s.charAt(0));
        for (int i = 2; i < dp.length; i++) { // off-by-one error, notice s.charAt(i)'s result is stored in dp[i + 1]
            long oneCharWays = ways(s.charAt(i-1)) * dp[i-1];
            long twoCharWays = ways(s.charAt(i - 2), s.charAt(i-1)) * dp[i - 2];
            dp[i] = add(oneCharWays, twoCharWays);
        }
        return (int)dp[s.length()]; // cast back
    }
}
