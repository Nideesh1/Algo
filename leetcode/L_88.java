class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m;
        int i2 = 0;
        
        while(i2 < nums2.length){
            nums1[i1] = nums2[i2]; i1++; i2++;
        }
        Arrays.sort(nums1);
    }
}

//https://leetcode.com/problems/merge-sorted-array/description/
