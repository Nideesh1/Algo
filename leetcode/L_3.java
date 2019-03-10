class Solution {
    public int lengthOfLongestSubstring(String s) {
        //The map should only have one char to one instance.
        //we go into the second while loop to bring the map
        //back to this state
        Map<Character,Integer> map = new HashMap<>();
        int begin = 0; int end = 0; int counter = 0;
        int d = 0;
        while(end < s.length()){
            char t1 = s.charAt(end);
            map.put(t1, map.getOrDefault(t1, 0) +1);
            if(map.get(t1) > 1) counter++;
            end++;
            if(counter > 0){
                char t2 = s.charAt(begin);
                if(map.get(t2) > 1) counter--;
                map.put(t2, map.get(t2) - 1);
                begin++;
            }
            
            d = Math.max(d, end - begin);
        }
        return d;
        
    }
}

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
