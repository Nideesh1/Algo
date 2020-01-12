class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for(int l : letters){
            freq[l - 'a']++;
        }
        //System.out.println(Arrays.toString(freq));
        return dfs(words,  score, freq, 0);
    }
    
    public int dfs(String[] words,  int[] score, int[] freq, int pos){
        if(pos == words.length) return 0;
        
        int res = 0;
        int tot = 0;
        int[] temp = Arrays.copyOf(freq, freq.length);
        
        String w = words[pos];

        int i = 0;
        for(i = 0; i < w.length(); i++){
            char c = w.charAt(i);
            
            if(temp[c - 'a'] > 0){
                temp[c-'a']--;
                tot += score[c-'a'];
            }else{
                break;
            }
        }
        
        
        if(i == w.length()){
            res = Math.max(res, tot + dfs(words, score, temp, pos + 1));
        }
        
        res = Math.max(res, dfs(words,score, freq, pos + 1));
        
        return res;
    }
}

//https://leetcode.com/problems/maximum-score-words-formed-by-letters/discuss/425129/java-backtrack-similar-to-78.-Subsets-1ms-beats-100/383940
