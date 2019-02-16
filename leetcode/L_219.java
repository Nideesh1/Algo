class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length ; i++){
            for(int j = i+1; j < i+1+k; j++){
                //System.out.println(i);
                //System.out.println(j);
                if( j >= nums.length) {continue;}
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

//https://leetcode.com/problems/contains-duplicate-ii/description/
