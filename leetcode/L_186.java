class Solution {
    public void reverseWords(char[] a) {
        
        rev(a, 0, a.length - 1);
        
        int i = 0; int j = 0;
        while(j <= a.length){
            if(j == a.length || a[j] == ' '){
                rev(a, i, j- 1);
                i = j + 1;
            }
            j++;
        }
        
    }
    
    public void rev(char[] a, int s, int e){
        while(s<= e){
            char t= a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }
}


//https://leetcode.com/problems/reverse-words-in-a-string-ii/discuss/53775/My-Java-solution-with-explanation
