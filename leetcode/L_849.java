class Solution {
    public int maxDistToClosest(int[] seats) { int n = seats.length;
        int[] l  = new int[n]; int[] r = new int[n];
        Arrays.fill(l, n);
        Arrays.fill(r, n);
        //Array fills is to assume that in the beginning everything is empty                                      
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){ l[i] = 0;}
            else if (i > 0){
                l[i] = l[i-1] + 1;
            }
        }  
        for(int i = n-1; i >= 0; i--){
            if(seats[i] == 1){ r[i] = 0;}
            else if (i < n-1){
                r[i] = r[i+1] + 1;
            }
        }  
         
        int res = 0;
        for(int i = 0; i < n; i++){
            if(seats[i] == 0){
            res = Math.max( res, Math.min(l[i], r[i]));
            }
        }                                    
        return res;                                      
    }
}

//https://leetcode.com/problems/maximize-distance-to-closest-person/description/
