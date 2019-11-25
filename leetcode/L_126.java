class Solution {
    Set<String> wordSet;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)) return res;
        wordSet = new HashSet<>(wordList);
        Map<String,List<String>> parentMap = new HashMap<>();
        
        for(String str : wordSet){
            parentMap.put(str, new ArrayList<>());
        }
        
        Map<String,Integer> distance = new HashMap<>();
        
        if(!bfs(beginWord, endWord, parentMap, distance)){
            return res;
        }
        //backtrack
        dfs(endWord, beginWord, parentMap, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(String cur, String beginWord, Map<String, List<String>> parentMap, List<List<String>> res, List<String> path){
        if(cur.equals(beginWord)){
            List<String> temp = new ArrayList<>(path);
            temp.add(beginWord);
            Collections.reverse(temp);
            res.add(temp);
        }else{
            path.add(cur);
            for(String par : parentMap.get(cur)){
                dfs(par, beginWord, parentMap, res, path);
            }
            path.remove(path.size() - 1);
        }
    }
    
    
    public boolean bfs (String beginWord, String endWord, Map<String, List<String>> parentMap, Map<String, Integer> distance){
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        distance.put(beginWord, 0);
        boolean found = false;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                String parent = q.poll();
                int level = distance.get(parent);
                List<String> nei = neigh(parent);
                for(String n : nei){
                    if(n.equals(endWord)) found = true;
                    if(!distance.containsKey(n)){
                        distance.put(n, level + 1);
                        parentMap.get(n).add(parent);
                        q.add(n);

                    }else if(distance.get(n) == level + 1){
                        parentMap.get(n).add(parent);                        
                    }
                }
                size--;
            }
        }
        return found;
    }
    
    public List<String> neigh(String word){
        List<String> res = new ArrayList<>();
        char[] ar = word.toCharArray();
        for(int i = 0; i < ar.length; i++){
            char c = ar[i];
            
            for(char j = 'a'; j <= 'z'; j++){
                ar[i] = j;
                String cur = new String(ar);
                if(wordSet.contains(cur)){
                    res.add(cur);
                }
            }
            
            ar[i] = c;
        }
        
        return res;
    }
    
}
//https://leetcode.com/problems/word-ladder-ii/discuss/435354/Java-Solution-or-BFS-%2B-DFS
