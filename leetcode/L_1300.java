class Solution {
    public int findBestValue(int[] arr, int target) {
        int res = 0;
        int sum = 0;
        int lo = 0;
        int hi = Integer.MIN_VALUE;
        for(int a : arr){
            hi = Math.max(a, hi);
            sum += a;
        }
        if(sum == target) return hi;
        int dif = Integer.MAX_VALUE; 
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int temp = sumAbove(arr, mid);
            if(temp > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
            if(Math.abs(target - temp) < dif ||
              Math.abs(target - temp) == dif && mid < res){
                res = mid;
                dif = Math.abs(target - temp);
            }
            
        }
        
        return res;
    }
    
    public int sumAbove(int[] arr, int mid){
        int res = 0;
        for(int i : arr){
            res += (i > mid) ? mid : i;
        }
        return res;
    }
}

//https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/464153/JAVA-Binary-Search
