class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0, prev = nums[0];
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i-1] >= nums[i] ) {
                int diff = nums[i-1] - nums[i] + 1;
                nums[i] += diff;
                res += diff;
            }
            //res += 
            
            // while (nums[i-1] >= nums[i]) {
            //     nums[i] ++;
            //     res++;
            // }
        }
        
        //System.out.println(Arrays.toString(nums));
        return res;
    }
}
