class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length())   return res;
        int n = s.length();
        int m = words.length;
        int inc = words[0].length();
        int count = 0; int start = 0;
        String cur = null; String front = null; 
        Map<String,Integer> curMap = new HashMap<>();
        Map<String,Integer> freq = new HashMap<>();
        
        for(String w : words){
            freq.put(w, freq.getOrDefault(w,0)+1);
        }
        
        for(int i = 0; i < inc; i++){
            start = i; count = 0;
            for(int j = i; j + inc <= n; j += inc){
                cur = s.substring(j, j + inc);
                if(freq.containsKey(cur)){
                    
                    curMap.put(cur, curMap.getOrDefault(cur, 0)+1);
                    
                    if(curMap.get(cur) <= freq.get(cur)) count++;
                    
                    while(curMap.get(cur) > freq.get(cur)){
                        front = s.substring(start, start + inc);
                        curMap.put(front, curMap.get(front)-1);
                        start += inc;
                        
                        if(curMap.get(front) < freq.get(front)) count--;
                    }
                    if(count == m){
                        res.add(start);
                        front = s.substring(start, start + inc);
                        curMap.put(front, curMap.get(front)-1);
                        start += inc;          
                        count--;
                    }
                     
                }else{
                    curMap.clear();
                    count = 0; 
                    start = j + inc;
                }
            }
            curMap.clear();
        }
    return res;
    }
}

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
