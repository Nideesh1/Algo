public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1; int j = n; int ans = 0;
        while ( i <= j){
            int m = i + (j-i)/2;
            if(guess(m) == 0){return m;}
            if(guess(m) == 1){
                i = m + 1;
            }
            if(guess(m) == -1){
                j = m - 1;
            }
        }
        return ans;
    }
}

//https://leetcode.com/problems/guess-number-higher-or-lower/description/
