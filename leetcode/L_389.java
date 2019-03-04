class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        
        for(char c : s.toCharArray()){
            int n = smap.getOrDefault(c,0) + 1;
            smap.put(c,n);
        }
        for(char c : t.toCharArray()){
            int m = tmap.getOrDefault(c,0) + 1;
            tmap.put(c,m);
        }
        for(Character c : tmap.keySet()){
            if(!smap.containsKey(c)){
                return c;
            }else if (tmap.get(c) > smap.get(c) ){
                return c;
            }
            
        }

        return 'a';
    }
}

//https://leetcode.com/problems/find-the-difference/
