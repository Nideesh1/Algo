class Solution {
    public int firstUniqChar(String s) {
        if(s.length() < 1){return -1;}
        Map<Character,Integer> index = new HashMap<>();
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] ar = s.toCharArray();
        for(int i = 0; i < ar.length; i++){
            int t = map.getOrDefault(ar[i], 0) + 1;
            map.put(ar[i], t);
            index.put(ar[i], i);
        }

        for(Character c : map.keySet()){
            if(map.get(c) <2){
                return index.get(c);
            }
        
        }
    
       return -1;
    }
    
}

//https://leetcode.com/problems/first-unique-character-in-a-string/description/
