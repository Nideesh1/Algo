class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        WordComp wc = new WordComp();
        PriorityQueue<Word> pq = new PriorityQueue<>(wc);
        for(String s : map.keySet()){
            pq.add(new Word(s, map.get(s)));
        }
        List<String> res = new ArrayList<>();
        while(k != 0){
            res.add(pq.poll().word);
            k--;
        }
        return res;
    }
}

class Word{
    String word; int freq; 
    public Word(String word, int freq){
        this.word = word; this.freq = freq;
    }
}

class WordComp implements Comparator<Word> {
    public int compare(Word w1, Word w2){
        if(w2.freq != w1.freq)
        return w2.freq - w1.freq;
        
        return w1.word.compareTo(w2.word);
    }
}

//https://leetcode.com/problems/top-k-frequent-words/
