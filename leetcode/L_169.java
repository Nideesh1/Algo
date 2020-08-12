class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        return dfs(nums, 0, n -1);
    }
    public int dfs(int[] nums, int i, int j){
        if(i == j) return nums[i];
        int m = (i + j)/2;
        int left = dfs(nums, i,m);
        int right = dfs(nums, m+1, j);
        
        if(left == right) return left;
        
        return count(nums, left, i , m) > count(nums, right, m + 1, j) ? left : right;
    }
    
    public int count(int[] ar, int c, int i, int j){
        int res = 0;
        for(int k = i; k <= j;k++){
            if(ar[k] == c) res++;
        }
        return res;
    }
}

