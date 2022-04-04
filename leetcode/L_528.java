class Solution {
    int[] prefix;
    int tot;
    Random rand = new Random();
    public Solution(int[] w) {
        prefix = new int[w.length];
        tot = 0;
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] += prefix[i-1] + w[i];
        }
        tot = prefix[w.length - 1];
    }
    
    public int pickIndex() {
        int target = rand.nextInt(tot);
        int l = 0, r = prefix.length - 1;
        while (l < r) {
            int m = (l+r)/2;
            if (target < prefix[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
 
 //https://leetcode.com/problems/random-pick-with-weight/solution/
