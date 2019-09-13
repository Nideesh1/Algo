class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ar = s.split("\\s");
        for(String st : ar){
            st.trim();
        }
        String res = "";
        for(int i = ar.length-1; i >= 0; i--){
            if(i != 0 && !ar[i].equals("") ){
                res += ar[i] + " ";
            }else if(!ar[i].equals(" ") ){
                res += ar[i];
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/reverse-words-in-a-string/
