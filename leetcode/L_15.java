class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int lo = i+1; int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0){
                    List<Integer> l = new ArrayList<>(); l.add(nums[i]);l.add(nums[lo]);l.add(nums[hi]); 
                    set.add(l);
                    lo++; hi--;
                }
                if(sum < 0){
                    lo++;
                }
                if(sum > 0){
                    hi--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
//https://leetcode.com/problems/3sum/
