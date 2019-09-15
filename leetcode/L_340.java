class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] ar = new int[256];
        int start = 0; int end = 0; int maxSize = 1; 
        int uni = 0;
        for(int i = 0; i < s.length(); i++){
            //System.out.print(s.charAt(i) + " ");
            if(ar[s.charAt(i)] == 0)uni++;
            ar[s.charAt(i)]++;
        }
        if(s.length() == 0) return 0;
        if(k == 0) return 0;
        Arrays.fill(ar, 0);
        ar[s.charAt(0)]++;
       
        for(int i = 1; i < s.length(); i++){
            ar[s.charAt(i)]++;
            end++;
            while(extra(ar, k)){
                ar[s.charAt(start)]--;
                start++;
            }
            
            if(end - start + 1 > maxSize){
                maxSize = end - start + 1;
            }
        }
        return maxSize;
    }
    
    public boolean extra(int[] ar, int k){
        int val = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] > 0)val++;

        }
        return k < val;
    }
    
}

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
