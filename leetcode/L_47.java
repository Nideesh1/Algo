class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            
            
            for(int i = 0; i < nums.length; i++){
                
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
                
                used[i] = true;
                temp.add(nums[i]);
                dfs(res, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
            
        }
    }
}

//https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
