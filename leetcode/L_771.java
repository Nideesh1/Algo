class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        Map<Integer, Integer> mj = new HashMap<Integer, Integer>();
        Map<Integer, Integer> sj = new HashMap<Integer, Integer>();
        for(Character c : s){
            int i = (int) c - 0;
            if(!sj.containsKey(i)){sj.put(i,1);}
            else{
                int t = sj.get(i);
                sj.put(i, t+1);
            }
        }
        int res = 0;
        for(Character c : j){
            int o = (int) c - 0;
            if(sj.containsKey(o)){
                res += sj.get(o);
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/jewels-and-stones/description/
