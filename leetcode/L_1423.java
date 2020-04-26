class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int winSum = 0; int tot = 0; int res = 0;
        for(int c : cardPoints) tot += c;
        int n = cardPoints.length;
        
        for(int i = 0; i < n - k; i++){
            winSum += cardPoints[i];
        }
        res = tot - winSum;
        
        for(int i = n - k; i < n; i++){
            winSum += cardPoints[i] - cardPoints[i - (n - k)];
            res = Math.max(res, tot - winSum);
        }
        
        return res;
    }
}

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597883/Javascript-and-C%2B%2B-solutions
