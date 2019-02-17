class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        int i = 0;
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(Character ch = 'a'; ch <= 'z'; ch++){
            map.put(ch, morse[i]); i++;
        }
        //System.out.println(map); 
        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(conv(s, map));
        }
        
        return set.size();
    }
    
    public String conv(String str, Map<Character,String> map){
        StringBuilder sb = new StringBuilder();
        char[] ar = str.toCharArray();
        for(Character c : ar){
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/unique-morse-code-words/description/
