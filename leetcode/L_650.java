class Solution {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while(n > 1){
            while(n % d == 0){
                ans += d;
                n /= d;
            }
            d++;
        }
        
        return ans;
    }
}

//https://leetcode.com/problems/2-keys-keyboard/solution/
