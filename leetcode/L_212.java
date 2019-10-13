class Solution {
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    public boolean outside(char[][] board, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return true;
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie tr = new Trie();
        TN root = tr.root;
        Set<String> res = new HashSet<>();
        for(String w : words) tr.insert(w);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if(root.ar[c - 'a'] != null){
                    dfs(board, i, j, root, c, res);
                }
            }
        }
        
        return new ArrayList<>(res);
    }
    public void dfs(char[][] board, int i, int j, TN cur, char c, Set<String> res){
        if(outside(board, i, j) || board[i][j] == '#' || cur.ar[c - 'a'] == null) return;
        char t = board[i][j]; board[i][j] = '#';
        cur = cur.ar[t - 'a'];
        if(cur != null && cur.word) {
            res.add(cur.words);
        }
        for(int k = 0; k < x.length; k++){
            int ro = i + x[k]; int co = j + y[k];
            if(outside(board, ro, co)) continue;
            dfs(board, ro, co, cur, board[ro][co], res);
        }
        board[i][j] = t;
        return;
    }
}


class Trie{
    TN root = new TN();
    public void insert(String str){
        TN cur = root;
        for(int i = 0; i < str.length(); i++){
            int ind = str.charAt(i) - 'a';
            if(cur.ar[ind] == null){
                cur.ar[ind] = new TN();
            }
            cur = cur.ar[ind];
        }
        cur.words = str;
        cur.word = true;
    }
}
class TN{
    TN[] ar = new TN[26];
    boolean word;
    String words;
    TN(){
    for(int i = 0; i < ar.length; i++){
        ar[i] = null;
    }
        word = false;
        words = null;
    }
}
