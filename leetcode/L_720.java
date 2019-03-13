class Solution {
    public String longestWord(String[] words) {
        List<String> l = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        int max = 0;
        outer: 
        for(String s : set){
            for(int i = 1; i < s.length(); i++){
                String t = s.substring(0,i);
                if(!set.contains(t)) continue outer;
            }
            l.add(s);
            max = Math.max(max, s.length());
        }
        Collections.sort(l);
        for(String s : l){
            if(s.length() == max) return s;
        }
        return "";
    }
}

//https://leetcode.com/problems/longest-word-in-dictionary/
