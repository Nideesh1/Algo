class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Set<Set<String>> set = new HashSet<>();
        
        for(String[] pair : pairs){
            Set<String> s = new HashSet<>();
            s.add(pair[0]);
            s.add(pair[1]);
            set.add(s);
        }
        
        if(words1.length != words2.length) return false;

        int i = 0;
        while(i < words1.length){
            if(words1[i].equals(words2[i])) {
                i++;
                continue;
            
            }
            String w1 = words1[i];
            String w2 = words2[i];
            boolean found = false;
            for(Set<String> s : set){
                if(s.contains(w1) && s.contains(w2)){
                    found = true;
                }
            }
            if(found == false) return false;
            i++;
        }
        
        return true;
    }
}

//https://leetcode.com/problems/sentence-similarity/
