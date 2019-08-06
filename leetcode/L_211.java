class WordDictionary {
    Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

class TN{
    TN[] ar = new TN[26];
    boolean word;
    TN(){
        for(int i = 0; i < ar.length; i++){
            ar[i] = null;
        }
        word = false;
    }
}
class Trie{
    TN root = new TN();
    
    void insert(String s){
        int len = s.length();
        TN p = root;
        for(int l = 0; l < len; l++){
            int ind = s.charAt(l) - 'a';
            if(p.ar[ind] == null){
                p.ar[ind] = new TN();
            }
                p = p.ar[ind];
        }
        p.word = true;
    }
    
    boolean search(String s){
        return dfs(s, 0, root);
        /*
        int len = s.length();
        TN p = root;
        for(int l = 0; l < len; l++){
            int ind = s.charAt(l) - 'a';
            if(p.ar[ind] == null){
                return false;
            }
            p = p.ar[ind];
        }
        return p.word;  
        */
    }
    
    boolean dfs(String s, int p, TN root){

        if( p == s.length() && root.word == true ) {return true;}
        else if(p == s.length()) {return false;}
        if(s.charAt(p) != '.') {
            int ind = s.charAt(p) - 'a';
            if(root.ar[ind] != null){
                root = root.ar[ind];
            } else{
                return false;
            }
            return dfs(s, p+1, root);
        }else {
            for(int i = 0; i < root.ar.length; i++){
                if(root.ar[i] != null){
                    if(dfs(s, p+1, root.ar[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 
 //https://leetcode.com/problems/add-and-search-word-data-structure-design/
