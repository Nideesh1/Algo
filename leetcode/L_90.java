class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos){
        res.add(new ArrayList<>(temp));
        for(int i = pos; i < nums.length; i++){
            if(i > pos && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            dfs(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
//https://leetcode.com/problems/subsets-ii/
//https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning


