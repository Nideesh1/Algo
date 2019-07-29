class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for(int i = 0; i < rank.length; i++){
            rank[order.charAt(i) - 'a'] = i;
        }
        outer:
        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i]; String s2 = words[i+1];
            
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++){

                if(rank[s1.charAt(j) - 'a'] < rank[s2.charAt(j) - 'a']) {
                    continue outer;
                }else{
                    return false;
                }
            }
            if(s1.length() > s2.length()) {

                return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/problems/verifying-an-alien-dictionary/
