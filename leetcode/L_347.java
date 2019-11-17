class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Comparator<Freq> co = new Comparator<Freq>(){
            public int compare(Freq f1, Freq f2){
                return f2.freq - f1.freq;
            }
        };
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(co);
        for(int i : map.keySet()){
            pq.add(new Freq(i, map.get(i)));
        }
        while(k != 0){
            res.add(pq.poll().val); k--;
        }
        return res;
    }
}

class Freq {
    int val; int freq;
    Freq(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}

//https://leetcode.com/problems/top-k-frequent-elements/
