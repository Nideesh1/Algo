//Trie Solution
class Solution {
    public String longestWord(String[] words) {
        Trie t = new Trie();
        int index = 1;
        for(String s : words){
            t.insert(s, index++);
        }
        t.words = words;        
        return t.dfs();
    }
}

class Node {
    char c; int index = 0;
    Map<Character,Node> map = new HashMap<>();
    Node(char c){
        this.c = c;
    }
}
class Trie {
    Node root = new Node('0');
    String[] words;
    
    public void insert(String s, int index){
        Node cur = root;
        for(char c : s.toCharArray()){
            cur.map.putIfAbsent(c, new Node(c));
            cur = cur.map.get(c);
        }
        cur.index = index;
    }
    
    public String dfs(){
        String ans = "";
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            Node n = stk.pop();
            if(n == root || n.index > 0){
                if(n != root){
                    String word = words[n.index - 1];
                    if(word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)){
                        ans = word;
                    }
                }
                            for(Node kid : n.map.values()){
                stk.push(kid);
                }
            }

            }
            return ans;
        }
                       
                 
}

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
