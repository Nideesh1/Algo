class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < time.length; i++){
            int t = time[i] % 60;
            int dif = 60 - t;
            if(dif == 60){
                dif = 0;
            }
            
            if(map.containsKey(t)){
                res += map.get(t);
            }
            map.put(dif, map.getOrDefault(dif, 0) +1);
        }
        return res;
    }
}

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
