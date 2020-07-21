class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void dfs( List<List<Integer>> res, List<Integer> temp, 
                int[] nums, int p){
        if(temp.size() > nums.length) return;
        res.add(new ArrayList<>(temp));

        for(int i = p; i < nums.length; i++){
            temp.add(nums[i]);
            dfs(res, temp, nums, i + 1);
            temp.remove(temp.size() -1);
        }
        
    }
}

//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-%28Subsets-Permutations-Combination-Sum-Palindrome-Partitioning%29
//https://leetcode.com/problems/subsets/
