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

//TLE
class Solution {
    Map<String,Integer> map = new HashMap<>();
    int[][] cache;
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        cache = new int[n][n];
        int res = dp(cardPoints, 0, n - 1, k);
        return res;
    }
    
    public int dp(int[] arr, int l, int r, int k){
        if(cache[l][r] != 0) return cache[l][r];
        //if(map.containsKey(l+"-"+r)) return map.get(l+"-"+r);
        if(k == 1){
            return Math.max(arr[l], arr[r]);
        }

        
        int ls = dp(arr, l + 1, r, k - 1);
        //map.put((l + 1) + "-"  + (r), ls);
        cache[l+1][r] = ls;
        
        int rs = dp(arr, l, r - 1, k - 1);
        //map.put(l + "-" + (r-1), rs);
        cache[l][r-1] = rs;
        
        int left = arr[l] + ls;
        int right = arr[r] + rs;
        
        int res = Math.max(left, right);
        //map.put(l+"-"+r, res);
        cache[l][r] = res;
        return res;
    }
}


//Good diagram. Different implementation not in Java
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597883/Javascript-and-C%2B%2B-solutions
