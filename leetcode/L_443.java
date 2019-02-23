//Three pointers, in place. Def revise
class Solution {
    public int compress(char[] chars) {
        int i = 0; int j = 0;
        int write = 0;
        int count = 1; int n = chars.length;
        while(i < n && j < n){
            char t = chars[i];
            count = 0;
            while((j == 0) || chars[i] == chars[j]){
                count++;
                j++;
                if(j == n){break;}
            }

            if(count > 1){
                chars[write] = t;
                for(char c : Integer.toString(count).toCharArray()){
                    chars[++write] = c;
                }
            }
            if(count == 1){
                chars[write] = t;
            }
            write++;
            i = j;
            
            
        }
        return write;
    }
}

//https://leetcode.com/problems/string-compression/description/
