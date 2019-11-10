class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int len = m + n;

        if(len % 2 == 0){
            int one = dfs(nums1, 0, nums2, 0, len/2);
            int two = dfs(nums1, 0, nums2, 0, len/2 + 1);
            
            return (double) (one + two)/2;
        }else{
            return dfs(nums1, 0, nums2, 0, len/2 + 1);
        }
    }
    public int dfs(int[] a, int aStart, int[] b, int bStart, int k){
        if(aStart >= a.length){
            return b[bStart + k - 1];
        }
        if(bStart >= b.length){
            return a[aStart + k - 1];
        }
        if(k == 1){
            return Math.min(a[aStart], b[bStart]);
        }
        
        int amid = aStart + k/2 - 1;
        int bmid = bStart + k/2 - 1;
        
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        
        if(aval <= bval){
            return dfs(a, amid + 1, b, bStart, k - k / 2);
        }else{
            return dfs(a, aStart, b, bmid + 1, k - k/2);
        }
    }
    
}

//https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2496/Concise-JAVA-solution-based-on-Binary-Search
