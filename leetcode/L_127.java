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


//Double ended
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>(); begin.add(beginWord);
        Set<String> end = new HashSet<>(); end.add(endWord);
        
        int len = 1;
        
        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size() > end.size()){
                Set<String> swap = begin;
                begin = end;
                end = swap;
            }
            
            Set<String> temp = new HashSet<>();
            for(String str : begin){
                char[] ar = str.toCharArray();
                
                for(int i = 0; i < ar.length; i++){
                    char ch = ar[i];
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        ar[i] = c;
                        String cur = new String(ar);
                        
                        if(end.contains(cur)) return len + 1;
                        
                        if(wordSet.contains(cur) && !cur.equals(beginWord)){
                            temp.add(cur);
                            wordSet.remove(cur);
                        }
                    }
                    
                    ar[i] = ch;
                }
                
                
            }
            
            
            
            begin = temp;
            len++;
        }
        return 0;
    }
}

//single ended
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        Queue<String> q = new LinkedList<>();
            int count = 0;
        q.add(beginWord);
        while(!q.isEmpty()){
            
            int n = q.size();
            for(int i = 0; i < n; i++){

                String cur = q.poll();
                
                if(cur.equals(endWord)) return count + 1;
                
                char[] ar = cur.toCharArray();
                
                for(int j = 0; j < ar.length; j++){
                    
                    char ori = ar[j];
                    
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        ar[j] = ch;
                        String temp = new String(ar);
                        if(set.contains(temp) && !temp.equals(beginWord)){
                            q.add(temp);
                            set.remove(temp);
                        }
                    }
                    
                    
                    ar[j] = ori;
                }
                
                
            }
            count++;
        }
        
        return 0;
    }
}
