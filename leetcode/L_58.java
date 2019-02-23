class Solution {
    public int lengthOfLastWord(String s) {
        String[] ar = s.split(" ");
        System.out.println(Arrays.toString(ar));
        if(ar.length == 0)return 0;
        return ar[ar.length -1].length();
    }
}

//https://leetcode.com/problems/length-of-last-word/description/
