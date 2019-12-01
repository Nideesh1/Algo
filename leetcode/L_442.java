class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                res.add(Math.abs(idx+1));
            }
            nums[idx] = - nums[idx];
        }
        return res;
    }
}

//https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution
