class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); int i = 0;
        Arrays.sort(s); int j = 0;
        int res = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                res++; i++; j++;
                continue;
            }
            
                j++;
            
            
        }
        return res;
    }
}

//https://leetcode.com/problems/assign-cookies/
