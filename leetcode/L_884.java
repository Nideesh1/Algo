class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> setA = new HashMap<>();
        String[] a = A.split(" ");
        for(String s : a){
            int c = setA.getOrDefault(s, 0) + 1;
            setA.put(s, c);
        }
        
        Map<String, Integer> setB = new HashMap<>();
        String[] b = B.split(" ");
        for(String s : b){
            int c = setB.getOrDefault(s, 0) + 1;
            setB.put(s, c);
        } 
        List<String> l = new ArrayList<>();
        for(String s : setA.keySet()){
            if(!setB.containsKey(s) && setA.get(s) == 1){
                l.add(s);
            }
        }
        
        for(String s : setB.keySet()){
            if(!setA.containsKey(s) && setB.get(s) == 1){
                l.add(s);
            }
        }   
        String[] res = new String[l.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = l.get(i);            
        }

        return res;
    }
}

//https://leetcode.com/problems/uncommon-words-from-two-sentences/
