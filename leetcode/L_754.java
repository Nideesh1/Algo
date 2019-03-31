class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0; int i = 1;
        while(s < target){
            s+= i;
            i++;
        }
        i--;
        int del = s - target;
        if(del % 2 == 0) return i;
 
        // System.out.println(s);
        // System.out.println(i);
        // System.out.println(del);
        
        while( del % 2 != 0){
            del += ++i;
        }
        return i;
    }
}

//https://leetcode.com/problems/reach-a-number/
