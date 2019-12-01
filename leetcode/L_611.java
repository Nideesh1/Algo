class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0 ; j++){
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }
    
    public int binarySearch(int[] nums, int l, int r, int x){
        while(l <= r && r < nums.length){
            int m = (l+r) / 2;
            if(x <= nums[m]){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
}
//https://leetcode.com/problems/valid-triangle-number/solution/
