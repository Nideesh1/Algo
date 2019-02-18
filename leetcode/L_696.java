class Solution {
    public int countBinarySubstrings(String s) {
        int[] ar = new int[s.length()];
        int p =0; ar[p] = 1; 
        for(int i = 1; i < s.length(); i++){
            
            if(s.charAt(i) == s.charAt(i-1)){
                ar[p]++;
            }else{
                p++; ar[p] = 1;
            }
            
        }
        //System.out.println(Arrays.toString(ar));
        int sum = 0;
        for(int i = 1; i <= p; i++){
            sum += Math.min(ar[i], ar[i-1]);
        }
        return sum;
    }
}

//https://leetcode.com/problems/count-binary-substrings/description/
