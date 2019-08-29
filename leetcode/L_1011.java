class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(D == 1 && weights.length == 2) return weights[0] + weights[1];
        if(D == 2 && weights.length == 2) return Math.max(weights[0], weights[1]);
        int lo = 0; for(int w : weights) lo = Math.max(lo, w);
        int hi = 0; for(int w : weights) hi += w;
        while(lo < hi){
            int mid = lo + (hi - lo )/ 2;
            
            int req = 1; int cur = 0;
            for(int i = 0; i < weights.length; i++){
                if(cur + weights[i] <= mid){
                    cur += weights[i];
                }else{
                    cur = weights[i]; req++;
                }
            }
            if(req <= D) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
