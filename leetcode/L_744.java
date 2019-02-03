class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0; int j = letters.length-1;
        while(i <= j){
            int m = (i+j)/2;
            if(letters[m] <= target){i = m+1;}
            else if(letters[m] >= target){
                j = m-1;
            }
        }
        return letters[(i)%letters.length];
    }
}


//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
