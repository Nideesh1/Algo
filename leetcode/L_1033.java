class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] ar = {a,b,c};
        Arrays.sort(ar);
        a = ar[0];
        b = ar[1];
        c = ar[2];
        
        if( Math.abs(a-b) == 1 && Math.abs(b-c) == 1) return new int[]{0,0};
        
        int aToB = Math.abs(a-b);
        int bToC = Math.abs(b-c);
        
        int arrOne = 0;
        int arrTwo = 0;
        
        System.out.println(aToB);
        System.out.println(bToC);
        
         if(aToB == 2 || bToC == 2){
             arrOne = 1;
         }else{
            arrOne += aToB == 1 ? 0 : 1;
            arrOne += bToC == 1 ? 0 : 1;
         }
        
         arrTwo += aToB == 1 ? 0 : aToB - 1;
         arrTwo += bToC == 1 ? 0 : bToC - 1;
        
        return new int[]{arrOne, arrTwo};
    }
}

//https://leetcode.com/problems/moving-stones-until-consecutive/
