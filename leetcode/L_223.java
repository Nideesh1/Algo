class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C-A) * (D-B);
        int a2 = (G-E) * (H-F);
        
        int left = Math.max(A,E);
        int right = Math.min(G, C);
        int bot = Math.max(B,F);
        int top = Math.min(D,H);
        int sub = 0;
        if(left < right && bot < top){
            sub = (right - left) * (top - bot);
        }
        return a1+a2-sub;
    }
}

//https://leetcode.com/problems/rectangle-area/
