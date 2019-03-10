class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int begin = 0; int end = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        int counter = map.size();
        while( end < s.length()){
            char t = s.charAt(end);
            if(map.containsKey(t)){
                map.put(t, map.get(t) - 1);
                if(map.get(t) == 0){
                    counter--;
                }
            }
            end++;
            while(counter == 0){
                char t1 = s.charAt(begin);
                if(map.containsKey(t1)){
                    map.put(t1, map.get(t1) + 1);
                    if(map.get(t1) > 0){
                        counter++;
                    }
                }
                if(end - begin == p.length()){
                    res.add(begin);   
                }
                begin++;
            }
            
        }
        return res;
    }
}

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
