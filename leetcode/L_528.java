class Solution {
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();
    public Solution(int[] w) {
        for(int x : w){
            tot += x;
            psum.add(tot);
        }
    }
    
    public int pickIndex() {
        int targ = rand.nextInt(tot);
        
        int lo = 0;
        int hi = psum.size() - 1;
        while(lo != hi){
            int mid = lo + (hi - lo)/2;
            if(targ < psum.get(mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
 
 //https://leetcode.com/problems/random-pick-with-weight/solution/
