class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Set<String> words = new HashSet<>();
        for(String w : wordList) words.add(w);
        Queue<Word> q = new LinkedList<>();
        set.add(beginWord); q.add(new Word(beginWord, 1));
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                Word cur = q.poll();
                if(cur.word.equals(endWord)) return cur.len;
                char[] ar = cur.word.toCharArray();
                for(int i = 0; i < ar.length; i++){
                    char t = ar[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        ar[i] = c;
                        String s = new String(ar);
                        if(!set.contains(s) && words.contains(s)){
                            q.add(new Word(s, cur.len+1));
                            set.add(s);
                        }
                    }
                    ar[i] = t;
                }
            }
        }
        return 0;
    }
}

class Word {
    String word; int len;
    Word(String word, int len){
        this.word = word;
        this.len = len;
    }
}
