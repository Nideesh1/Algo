class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] res = new long[n];
        int i = 0;
        int len = (intLength + 1) / 2;
        long l = (long) Math.pow(10, len - 1);
        long r = (long) Math.pow(10, len) - 1;
        //System.out.println(l + " " + r); 
        
        for (int q : queries) {
            
            if (q <= r - l + 1) {
                String left = Long.toString(l + q - 1);
                String right = new StringBuilder(left).reverse().toString();
                
                res[i++] = Long.parseLong(left + right.substring(intLength % 2));    
            } else {
                res[i++] = -1;
            }
            
        }
        
        return res;
    }
}

//https://leetcode.com/problems/find-palindrome-with-fixed-length/discuss/1887453/Detailed-Explanation-with-comments-oror-Easy-Solution
