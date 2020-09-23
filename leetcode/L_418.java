class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0; int len = s.length();
        for(int i = 0; i < rows; i++){
            start += cols;
            if(s.charAt(start % len) == ' '){
                start++;
            }else{
                while(start > 0 && s.charAt((start -1) % len) != ' '){
                    start--;
                }
            }
        }
        return start / len;
    }
}

//https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution

