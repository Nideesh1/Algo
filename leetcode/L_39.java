class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0){
            List<Integer> l = new ArrayList<>(temp);
            res.add(l);
            return;
        }else{
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                //we can reuse so it will be i and not i+1
                dfs(res, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
}
//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
