class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        if(n <= 1){return -1;}
        int[] l = new int[n]; l[0] = nums[0];
        int[] r = new int[n]; r[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            l[i] += l[i-1] + nums[i];
        }
        for(int i = n-2; i >= 0; i--){
            r[i] += r[i+1] + nums[i];
        }
        for(int i = 0; i < n; i++){
            if(i == 0){if (r[i+1] == 0){return i;}}
            if(i == n-1){if (l[i-1] == 0){return i;}}
            if(i >= 1 && i <= n-2){ if(l[i-1] == r[i+1]){return i;}}
        }
        return -1;
    }
}

//https://leetcode.com/problems/find-pivot-index/description/
