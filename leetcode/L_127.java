class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(beginWord); Set<String> words = new HashSet<>(wordList);
        vis.add(beginWord);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int s = 0; s < size; s++){
                String cur = q.poll();
                if(cur.equals(endWord)) return level;
                char[] ar = cur.toCharArray();
                
                for(int i = 0; i < ar.length; i++){
                    char t = ar[i];
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        ar[i] = c;
                        String temp = new String(ar);
                        if(!vis.contains(temp) && !temp.equals(beginWord) && words.contains(temp)){
                            vis.add(temp); q.add(temp);
                        }
                    }
                    
                    
                    ar[i] = t;
                }
                
            }
        }
        return 0;
    }
}
