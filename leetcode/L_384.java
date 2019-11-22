class Solution {
    int[] ar;
    int[] ori;
    public Solution(int[] nums) {
        ar = nums;
        ori = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        ar = ori;
        ori = ori.clone();
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < ar.length; i++){
            swap(i, rand(i, ar.length));
        }
        return ar;
    }
    Random rand = new Random();
    public int rand(int i, int j){
        return rand.nextInt(j - i) + i;
    }
    
    public void swap(int i, int j){
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 
 //https://leetcode.com/problems/shuffle-an-array/solution/
