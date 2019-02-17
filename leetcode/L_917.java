class Solution {
    public String reverseOnlyLetters(String S) {
        char[] a = S.toCharArray();
        int i = 0; int j = a.length -1;
        while( i <= j){
            if(!Character.isLetter(a[i])) {i++; continue;}
            else if(!Character.isLetter(a[j])) {j--; continue;}        
            else{
                char t = a[i]; a[i] = a[j]; a[j] = t;
                i++; j--;
            }
        
        }
        return new String(a);
    }
}

//https://leetcode.com/problems/reverse-only-letters/description/
