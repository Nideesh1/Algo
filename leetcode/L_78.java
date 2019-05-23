class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> l, int start){
        res.add(new ArrayList<>(l));
        for(int i = start; i < nums.length; i++){
            l.add(nums[i]);
            dfs(res, nums, l, i+1);
            l.remove(l.size()-1);
        }
    }
}

//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-%28Subsets-Permutations-Combination-Sum-Palindrome-Partitioning%29
