import java.util.concurrent.ConcurrentHashMap;
//https://leetcode.com/problems/find-common-characters/discuss/259707/Java-Clean-Solution
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++){
            int minCount = Integer.MAX_VALUE;
            for (String s : A){
                int wordCount = 0;
                for (char cur_c : s.toCharArray()) if (cur_c == c) wordCount++;
                minCount = Math.min(minCount, wordCount);
            }
            
            for (int i = 0; i < minCount; i++) result.add("" + c);
        }
        
        return result;
}
    
    
}



class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        
        char[] ar = A[0].toCharArray();
        ConcurrentHashMap<Character,Integer> map = new ConcurrentHashMap<>();
        for(char c : ar){
            int t = map.getOrDefault(c,0) + 1; map.put(c,t);
        }

        for(int i = 1; i < A.length; i++){
            retain(map, A[i]);
        }
        for(Character c : map.keySet()){
            int times = map.get(c);
            for(int i = 0; i < times; i++){
                res.add("" + c);
            }
        }
        
        
        return res;
    }
    
    public void retain(ConcurrentHashMap<Character,Integer> map, String s){
        char[] ar = s.toCharArray();
        Map<Character,Integer> mapS = new HashMap<>();
        for(char c : ar){
            int t = mapS.getOrDefault(c,0) + 1; mapS.put(c,t);
        }

        for(Character c : map.keySet()){
            if(!mapS.containsKey(c)){
                map.remove(c);
            }else{
                int num1 = map.get(c);
                int num2 = mapS.get(c);
                map.put(c, Math.min(num1,num2));
            }
        }
    }
}

//https://leetcode.com/problems/find-common-characters/
