class StreamChecker {
    StringBuilder sb = new StringBuilder();
    int max = 0;
    Trie tr = new Trie();    
    public StreamChecker(String[] words) {
        for(String w : words){
            StringBuilder rev = new StringBuilder(w);
            tr.insert(rev.reverse().toString());            
        }
        
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TN cur = tr.root;
        for(int i = sb.length()-1; i >= 0 && cur != null; i--){
            int ind = sb.charAt(i) - 'a';
            cur = cur.ar[ind];
            if(cur != null && cur.word) return true;

        }
        return false;
    }
}

class Trie{
    TN root = new TN();
    public void insert(String s){
        TN cur = root;
        for(int i = 0; i < s.length(); i++){
            int ind = s.charAt(i) - 'a';
            if(cur.ar[ind] == null){
                cur.ar[ind] = new TN();
            }
            cur = cur.ar[ind];
        }
        cur.word = true;
    }
    
}
class TN{
    TN[] ar = new TN[26]; boolean word = false;
    TN(){
        for(int i = 0; i < ar.length; i++){
            ar[i] = null;
        }
    }
}


//https://leetcode.com/problems/stream-of-characters/
