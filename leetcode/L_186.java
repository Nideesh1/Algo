class Solution {
    public void reverseWords(char[] s) {
        rev(s, 0, s.length - 1);
        for(int j = 0, i = 0; j <= s.length; j++){
            if(j == s.length || s[j] == ' '){
                rev(s, i, j - 1);
                i = j + 1;
            }
        }
    }
    
    public void rev(char[] s, int l, int r){
        while(l < r){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }
}

//https://leetcode.com/problems/reverse-words-in-a-string-ii/discuss/53775/My-Java-solution-with-explanation
