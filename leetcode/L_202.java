class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int x = n; int y = n;
        
        while(x > 1){
            x = hap(x);
            if(x == 1) return true;
            y = hap(hap(y));
            if(y == 1) return true;
        
            if(x == y) return false;
            
        }

        return true;
    }
    
    public int hap(int n){
        String s = String.valueOf(n);
        int sum = 0;
        char[] ar = s.toCharArray();
        for(char c : ar){

            sum += Math.pow((int) c - '0', 2);
        }
        return sum;
    }
}

//https://leetcode.com/problems/happy-number/
