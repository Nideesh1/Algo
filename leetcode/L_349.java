class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<Integer>();
        for(Integer i : nums2){
            if(bin(nums1, i)){set.add(i);}
        }
        List<Integer> l = new ArrayList<>();
        for(Integer i : set){l.add(i);}
        int[] res = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            res[i] = l.get(i);
        }
        return res;
    }
    
    public boolean bin(int[] arr, int target){
        int i = 0; int j = arr.length-1;
        while( i <= j){
            int m = (i+j)/2;
            if(arr[m] == target){return true;}
            if(arr[m] < target){i = m + 1;}
            if(arr[m] > target){j = m - 1;}
        }
        return false;
    }
}

//https://leetcode.com/problems/intersection-of-two-arrays/description/
