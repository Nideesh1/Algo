class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1 = new 
            HashMap<>();
        Map<Character,Character> map2 = new
            HashMap<>();
        
        if(s.length() != t.length()) return false;
        
        int i = 0;
        for(char c : s.toCharArray()){

            if(!map1.containsKey(c) && 
              !map2.containsKey(t.charAt(i))){
                map1.put(c,t.charAt(i));
                map2.put(t.charAt(i), c);
            }else{
                System.out.println(map1);
                System.out.println(map2);
                if(c != map2.getOrDefault(t.charAt(i), '-') ||
                  t.charAt(i) != map1.getOrDefault(c, '-')){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!m1.containsKey(s.charAt(i))) m1.put(s.charAt(i), i);
            if(!m2.containsKey(t.charAt(i))) m2.put(t.charAt(i), i);
            if(m1.get(s.charAt(i)) != m2.get(t.charAt(i))) return false;
        }
        System.out.println(m1);         System.out.println(m2);
        return true;
    }
}

//https://leetcode.com/problems/isomorphic-strings/
