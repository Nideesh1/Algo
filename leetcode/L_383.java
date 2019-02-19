class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            int t = m.getOrDefault(c, 0) + 1;
            m.put(c, t);
        }
        
        for(Character c : ransomNote.toCharArray()){
            int t = m.getOrDefault(c, 0);
            t--;
            if(t < 0){return false;}
            m.put(c, t);
            
        }
        return true;
    }
}

//https://leetcode.com/problems/ransom-note/description/
