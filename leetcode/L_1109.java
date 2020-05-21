class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        
        for(int[] b : bookings){
            for(int i = b[0]; i <= b[1]; i++){
                res[i-1] += b[2];
            }
        }

        return res;
    }
}

//https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        
        for(int[] b : bookings){
            res[b[0] - 1] += b[2];
            if(b[1]  < n) res[b[1] ] -= b[2]; 
        }
        
        for(int i = 1; i < res.length; i++){
            res[i] += res[i-1];
        }
        
        return res;
    }
}