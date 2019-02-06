public class Solution {
    public String reverseString(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }
}

class Solution {
    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }
    public void helper(int i, int j, char[] s){
        if(i >= j){return;}
        
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        helper(i+1, j-1, s);
    }
}

//https://leetcode.com/problems/reverse-string/description/
