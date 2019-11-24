class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int res = 0;
        for(int i : nums){
            if(set.contains(i - 1)) continue;
            int count = 0;
            int k = i;
            while(set.contains(k++)){
                count++;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
}

//https://leetcode.com/problems/longest-consecutive-sequence/
