class Solution {
    public int findLUSlength(String a, String b) {
        if(a.length() > b.length() && !a.equals(b)){ return a.length();}
        if(a.length() < b.length() && !a.equals(b)){ return b.length();}
        if(a.length() == b.length() && !a.equals(b)){ return b.length();}        
        if(a.equals(b)){return -1;}
        return 0;
    }
}

//https://leetcode.com/problems/longest-uncommon-subsequence-i/solution/
