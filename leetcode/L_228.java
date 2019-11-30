class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0, j = 0;
        for(; j < n;j++){
            if(j+1 < n && nums[j+1] == nums[j] + 1){
                continue;
            }
            if(i == j){
                res.add("" + nums[i]);
            }else{
                res.add("" + nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}

//https://leetcode.com/problems/summary-ranges/solution/
