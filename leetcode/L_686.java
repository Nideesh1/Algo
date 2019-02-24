class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A); int count = 1;
        while(sb.length() < B.length() ){
            sb.append(A); count++;
        }
        if(sb.indexOf(B) != -1)return count;
        count++;
        if(sb.append(A).indexOf(B) != -1) return count;
        return -1;
    }
}

//https://leetcode.com/problems/repeated-string-match/description/
