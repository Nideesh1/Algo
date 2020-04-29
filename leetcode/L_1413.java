class Solution {
    public int minStartValue(int[] nums) {
        int[] low = new int[nums.length];
        low[0]= nums[0];
        for(int i = 1; i < nums.length; i++){
            low[i] = nums[i] + low[i-1];
        }
        int res = Integer.MAX_VALUE;
        for(int l : low) res = Math.min(l, res);
        return res < 0 ? -res + 1 : 1;
    }
}

