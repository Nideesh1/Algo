class Solution {
    public String minWindow(String s, String t) {
        int[] txt = new int[256];
        int[] pat = new int[256];
        
        for(int i = 0; i < t.length(); i++){
            pat[t.charAt(i)]++;
        }
        
        int start = 0; int st = -1; int size = Integer.MAX_VALUE; int count = 0;
        for(int i = 0; i < s.length(); i++){
            txt[s.charAt(i)]++;
            
            if(pat[s.charAt(i)] != 0 && txt[s.charAt(i)] <= pat[s.charAt(i)]){
                count++;
            }
            
            if(count == t.length()){
                while(pat[s.charAt(start)] == 0 || txt[s.charAt(start)] > pat[s.charAt(start)]){
                    if(txt[s.charAt(start)] > pat[s.charAt(start)]){
                        txt[s.charAt(start)]--;
                    }
                    start++;
                }
                
                if(i - start + 1 < size){
                    size = i - start + 1;
                    st = start;
                }
            }
        }
        
        if(st == -1) return "";
        return s.substring(st, st + size);
    }
}

//https://leetcode.com/problems/minimum-window-substring/
