class Solution {
    public int mySqrt(int x) {
        if(x == 0){return x;}
        int i = 1; int j = x; int ans = 0;
        while(i <= j){
            int m = i + (j - i)/2;
            if(m *m == x){return m;}
            if(m  >= x/m){ j = m-1; }
            if(m<= x/m){ i = m + 1; ans = m;}
        }
        return ans;
    }
}

//https://leetcode.com/problems/sqrtx/description/
