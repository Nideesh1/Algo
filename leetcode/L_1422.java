class Solution {
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 1; i++){
            int left = score(arr, 0, i, true);
            int right = score(arr, i + 1, arr.length -1, false);
            max = Math.max(max, left + right);
        }
        return max;
    }
    
    public int score(char[] arr, int l, int r, boolean zero){
        int res = 0;
        for(int i = l; i <= r; i++){
            if(zero){
                if(arr[i] == '0') res++;                
            }else{
                if(arr[i] == '1') res++;
            }
        }
        return res;
    }
}