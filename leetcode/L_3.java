class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0, repeats = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            map.put(c, map.getOrDefault(c,0) + 1);
            if (map.get(c) > 1) repeats++;
            
            while (repeats > 0) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 1) {
                    repeats--;
                }                
                l++;
            }
            res = Math.max(res, r -l);
        }
        return res;
    }
}

//https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1629847/Java-Simple-Sliding-Window-Technique-With-Comments
