class Solution {
    
    long n = 0;
    long ans = 0;
    long diff = Long.MAX_VALUE;
    
    public String nearestPalindromic(String n) {
        this.n = Long.parseLong(n);
        diff = Long.MAX_VALUE;
        
        long leftHalf = Long.parseLong(n.substring(0, (n.length() + 1)/2));

        concat(leftHalf - 1);
        concat((leftHalf - 1)*10 + 9);
        concat(leftHalf);
        concat(leftHalf + 1);
        concat((leftHalf + 1)/10);
        return ans + "";
    }
    
    public void concat(long leftHalf){
        String s = "" + leftHalf, rs = new StringBuilder(s).reverse().toString();
        update(s + rs); // abc - abccba
        update(s + rs.substring(1)); //abc - abcba
    }
    
    public void update(String val){
        try{
            long tmp = Long.parseLong(val);
            if(tmp == n) return;
            if(Math.abs(tmp - n) < diff || Math.abs(tmp - n) == diff && tmp < ans){
                ans = tmp;
                diff = Math.abs(tmp - n);
            }
        }
        catch(Exception e){}
    }
    
}

//https://leetcode.com/problems/find-the-closest-palindrome/discuss/102400/Concise-Java-Solution
