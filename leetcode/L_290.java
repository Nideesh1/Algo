class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();        
        String[] ar = str.split(" ");
        if(pattern.length() != ar.length)return false;
        
        int i = 0;
        for(Character c : pattern.toCharArray()){
            if(!map.containsKey(pattern.charAt(i)) && 
              !map2.containsKey(ar[i])){
                map.put(c, ar[i]);
                map2.put(ar[i], c);
            }else{
                String currWord = ar[i];
                
                if(c != map2.get(currWord) || !currWord.equals(map.get(c))){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}

//https://leetcode.com/problems/word-pattern/
