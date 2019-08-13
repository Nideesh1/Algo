class Solution {
    public int singleNumber(int[] nums) {
        int a = 0; 
        int b = 0;
        for(int i : nums){
            a = (a ^ i) & ~b;
            b = (b ^ i) & ~a;
        }
        return a;
    }
}

//https://leetcode.com/problems/single-number-ii/
