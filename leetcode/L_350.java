class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0; int j = 0; List<Integer> l = new ArrayList<Integer>();
        while((i < nums1.length) && j < (nums2.length)){
            if(nums1[i] < nums2[j]){i++;}
            else if(nums1[i] > nums2[j]){j++;}
            else if(nums1[i] == nums2[j]){l.add(nums1[i]); i++; j++;}
        }
        int[] res = new int[l.size()];
        for(int k = 0; k < res.length;k++){
            res[k] = l.get(k);
        }
        return res;
    }
}

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
