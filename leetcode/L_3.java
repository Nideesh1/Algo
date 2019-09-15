class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] ar = new int[256];
        int size = Integer.MIN_VALUE;
        int start = 0;
        for(int j = 0; j < s.length(); j++){
            ar[s.charAt(j)]++;
            while(!valid(ar) && start < j){
                ar[s.charAt(start)]--;
                start++;
            }
            if(j - start + 1 > size){
                size = j - start + 1;
            }
        }
        return size;
    }
    
    public boolean valid(int[] ar){
        for(int i : ar){
            if (i > 1) return false;
        }
        return true;
    }
}

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
