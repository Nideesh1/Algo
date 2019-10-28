class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int p = bin(nums, target);
        if(p == -1) return new int[]{-1,-1};
        int i = p - 1;
        int j = p + 1;
        while(i >= 0 && nums[i] == target){
            i--;
        }
        while(j < nums.length && nums[j] == target){
            j++;
        }
        res[0] = i+1; res[1] = j-1;
        //System.out.println(j);
        return res;
    }
    
    public int bin(int[] nums, int target){
        int i = 0; int j = nums.length - 1;
        while(i <= j){
            int m = i + (j-i)/2;
            if(target == nums[m]) return m;
            if(target < nums[m]){
                j = m-1;
            }else{
                i = m+1;
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
