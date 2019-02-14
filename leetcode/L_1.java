class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null && i != map.get(nums[i])){
                int[] ar = {i, map.get(nums[i])};
                Arrays.sort(ar);
                return ar;
            }
        }
        System.out.println(map);
        return null;
    }
}

//https://leetcode.com/problems/two-sum/description/
