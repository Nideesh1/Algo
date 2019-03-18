class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hr = {8,4,2,1};
        int[] mn = {32,16,8,4,2,1};
        for(int i = 0; i <= num; i++){
            List<Integer> l1 = genList(hr, i);
            List<Integer> l2 = genList(mn, num - i);
        
            for(int j = 0; j < l1.size(); j++){
                if(l1.get(j) >= 12) continue;
                for(int k = 0; k < l2.size(); k++){
                    if(l2.get(k) >= 60 ) continue;
                res.add(l1.get(j) + ":" + (l2.get(k) < 10 ? "0" + l2.get(k) : l2.get(k)));
                }
            }
        }
        
        
        
        return res;
    }
    
    public List<Integer> genList(int[] hr, int count){
        List<Integer> r = new ArrayList<>();
        recur(hr, count, r, 0, 0); 
        return r;
    }
    
    public void recur(int[] hr, int count, List<Integer> r, int sum, int pos){
        if(count == 0){
            r.add(sum); return;
        }
        for(int i = pos; i < hr.length; i++){
            recur(hr, count - 1, r, sum + hr[i], i+1);
        }
    }
}

//https://leetcode.com/problems/binary-watch/
