class Solution {
    String beginWord; String endWord; Set<String> words;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        this.beginWord = beginWord; this.endWord = endWord; words = new HashSet<>(wordList);
        //System.out.println(nei("hot"));
        Map<String,List<String>> map = new HashMap<>();
        if(!bfs(map)) return res;
        System.out.println(map);
        List<List<String>> ans = new ArrayList<>();
        dfs(map, endWord, new ArrayList<>(), ans);
        //System.out.println(ans);
        return ans;
    }
    
    public void dfs(Map<String,List<String>> map, String cur, List<String> temp,
                   List<List<String>> ans){
        if(cur.equals(beginWord)){
            List<String> path = new ArrayList<>(temp);
            path.add(beginWord);
            Collections.reverse(path);
            ans.add(path);
        }else{
            temp.add(cur);
            for(String s : map.get(cur)){
                dfs(map, s, temp, ans);
            }
            temp.remove(temp.size() - 1);
        }
    }
    
    public boolean bfs(Map<String,List<String>> map){
        boolean res = false;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Map<String,Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int s = 0; s < size; s++){
                String cur = q.poll();
                if(cur.equals(endWord)) res = true;
                int level = dist.get(cur);
                List<String> nei = nei(cur);
                for(String n : nei){
                    if(!dist.containsKey(n)){
                        q.add(n);
                        List<String> l = new ArrayList<>(); l.add(cur);
                        map.put(n, l);
                        dist.put(n, level + 1);
                    }else if(level + 1 == dist.get(n)){
                        map.get(n).add(cur);
                    }
                }
            }
        }
        return res;
    }
    
    public List<String> nei(String word){
        List<String> res = new ArrayList<>();
        char[] ar = word.toCharArray();
        for(int i = 0; i < ar.length; i++){
            char c = ar[i];
            
            for(char j = 'a'; j <= 'z'; j++){
                ar[i] = j;
                String cur = new String(ar);
                if(words.contains(cur)){
                    res.add(cur);
                }
            }
            
            ar[i] = c;
        }
        
        return res;
    }
}
//https://leetcode.com/problems/word-ladder-ii/discuss/435354/Java-Solution-or-BFS-%2B-DFS
