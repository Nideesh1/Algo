/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if(!sea.hasShips(topRight, bottomLeft)) return 0;
        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        
        int mx = (topRight[0] + bottomLeft[0])/2;
        int my = (topRight[1] + bottomLeft[1])/2;
        
        int upl = countShips(sea, new int[]{mx, topRight[1]}, new int[]{bottomLeft[0], my + 1});
        int upr = countShips(sea, topRight, new int[]{mx + 1, my + 1});
        int dwl = countShips(sea, new int[] {mx, my}, bottomLeft);        
        int dwr = countShips(sea, new int[]{topRight[0], my}, new int[]{mx + 1, bottomLeft[1]});
        
        return upl + upr + dwl + dwr;
    }
}

//https://leetcode.com/problems/number-of-ships-in-a-rectangle/discuss/440768/Java-Simple-divide-and-conquer-solution-with-explanation
