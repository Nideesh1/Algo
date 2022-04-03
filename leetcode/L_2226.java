class Solution {
    public int maximumCandies(int[] candies, long k) {
        int lo = 0, hi = -1;
        for (int c : candies) hi = Math.max(hi, c);
        while (lo < hi) {
            int m = (lo + hi) /2;
            if (cansplit(candies, k, m)) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return cansplit(candies, k, lo) ? lo : lo - 1;
    }
    
    public boolean cansplit(int[] candies, long k, int m) {
        if (m == 0) return true;
        long total = 0;
        for (int c : candies) {
            total += (c / m);
            if (total >= k) return true;
        }
        return false;
    }
}

//https://leetcode.com/problems/maximum-candies-allocated-to-k-children/discuss/1908797/Binary-Search-Solution-with-Explanation-or-Java-or-O(n-log(max(candies)))
