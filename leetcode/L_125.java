class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.length() <= 1)return true;
        
        char[] ar = s.toCharArray(); int n =ar.length;
        int l = 0; int r = n - 1;
        
        while( l <= r && l < n && r >= 0) outer : {
            
            while(!Character.isLetterOrDigit(ar[l]) ){ l++; if(l == n)break outer;    }
            while(!Character.isLetterOrDigit(ar[r]) ) {r--;  if(r == 0)break outer; }
            
            
            if(Character.toLowerCase(ar[l]) != Character.toLowerCase(ar[r])){
                System.out.println(ar[l] + " " + ar[r]);
                return false;
            }
            l++; r--;
        }
        return true;
    }
}

//https://leetcode.com/problems/valid-palindrome/description/
