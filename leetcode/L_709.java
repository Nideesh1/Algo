class Solution {
    public String toLowerCase(String str) {
        char[] ar = str.toCharArray();
        for(int i = 0; i < ar.length; i++){
            if('A' <=  ar[i] && ar[i] <= 'Z'){
                ar[i] = (char) (ar[i] - 'A' + 'a');
            }
        }
        return new String(ar);
    }
}

//https://leetcode.com/problems/to-lower-case/description/
