class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = 0;
        int gone = 0;

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                repeat = nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                gone = i;
            }
        }
        
        return new int[]{repeat,gone};
    }
}

//https://leetcode.com/problems/set-mismatch/
