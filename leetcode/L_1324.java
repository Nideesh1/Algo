class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] words = s.split(" ");
        int max = 0;        
        for(String w : words){
            max = Math.max(max, w.length());
        }
        for(int i = 0; i < max; i++){
            StringBuilder sb = new StringBuilder();
            for(String w : words){
                sb.append(i < w.length() ? w.charAt(i) : " ");
            }
            
            while(sb.charAt(sb.length() - 1) == ' '){
                sb.deleteCharAt(sb.length() - 1);
            }
            res.add(sb.toString());
        }
        return res;
    }
}

//https://leetcode.com/problems/print-words-vertically/discuss/484322/JavaPython-3-Straight-forward-codes-w-brief-explanation-and-analysis.
