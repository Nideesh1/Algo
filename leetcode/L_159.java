class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int begin = 0; int end = 0;
        int len = 0; int counter = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        while(end < s.length()){
            char t1 = s.charAt(end);
            map.put(t1, map.getOrDefault(t1 ,0) + 1);
            if(map.get(t1) == 1) counter++;
            end ++;
            if(counter > 2){
                char t2 = s.charAt(begin);
                map.put(t2, map.get(t2) - 1);
                if(map.get(t2) == 0) counter--;
                begin++;
            }
            
            len = Math.max(len, end - begin);
            
        }
        return len;
    }
}

//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
