class Solution {
    public int binaryGap(int N) {
        List<Integer> l = new ArrayList<>();
        int i = 0;
        while(N != 0){
            int t = N & 1;
            if(t == 1){
                l.add(i); 
            }
            i++;
            N = N >> 1;
        }
        int max = 0;
        for(int j = 1; j < l.size(); j++){
            max = Math.max(max, l.get(j) - l.get(j-1));
        }
        return max;
    }
}

//https://leetcode.com/problems/binary-gap/
