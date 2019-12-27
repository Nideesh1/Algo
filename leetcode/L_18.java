class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    
    public List<List<Integer>> kSum(int[] nums, int start, int k, int target){
        Set<List<Integer>> res = new HashSet<>();
        if(k == 2){
            
            int lo = start; int hi = nums.length - 1;
            
            while(lo < hi){
                
                int sum = nums[lo] + nums[hi];
                
                if(sum == target){
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[lo]);
                    r.add(nums[hi]);
                    res.add(r);
                    
                    lo++; hi--;
                }
                if(sum < target){
                    lo++;
                }
                if(sum > target){
                    hi--;
                }
                
            }
            
        }else{
            
            for(int i = start; i < nums.length - 1 - (k-2) ; i++){
                if(i > start && nums[i] == nums[i-1]) continue;
                List<List<Integer>> temp = kSum(nums, i+1, k - 1, target - nums[i]);
                for(List<Integer> t : temp){
                    t.add(0, nums[i]);
                }
                
                res.addAll(temp);
            }
        }
        
        return new ArrayList<>(res);
    }
}

//https://leetcode.com/problems/4sum/
