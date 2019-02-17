class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = rev(arr[i]);
        }
        //System.out.println(Arrays.toString(arr));
        String res = String.join(" ", arr);
        return res;
    }
    
    public String rev(String str){
        char[] t = str.toCharArray(); int n = t.length; 
        for(int i = 0; i < n/2; i++){
            char c = t[i];
            t[i] = t[n-1-i];
            t[n-1-i] = c;
        }
        return new String(t);
    }
}

//https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
