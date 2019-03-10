class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        //each ends of the window
        int begin = 0; int end = 0; 
        //head is to anchor the minimum length.
        //we imagine length as MAX first
        int head = 0; int length = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        int counter = map.size();
        while( end < s.length()){
            
            char t1 = s.charAt(end);
            if(map.containsKey(t1)){
                map.put( t1, map.get(t1) - 1 );
                if(map.get(t1) == 0){
                    counter--;
                }
            }
            end++;
            
            while(counter == 0){
                char t2 = s.charAt(begin);
                if(map.containsKey(t2)){
                    map.put(t2 , map.get(t2) + 1);
                    if(map.get(t2) > 0){
                        counter++;
                    }
                }
                if(end - begin < length){
                    length = end - begin;
                    head = begin;
                }
                begin++;
            }
            
        }
        return  length == Integer.MAX_VALUE? "" : s.substring(head, head + length);
        
    }
}

//https://leetcode.com/problems/minimum-window-substring/
