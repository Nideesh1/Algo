/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return dfs(sea, topRight, bottomLeft);
    }
    public int dfs(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0], y1 = bottomLeft[1], x2 = topRight[0], y2 = topRight[1];
        if (x1 > x2 || y1 > y2) return 0;
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (x1 == x2 && y1 == y2) return 1;

        
        int mx = (x1 + x2) / 2;
        int my = (y1 + y2) / 2;

        int botL = dfs(sea, new int[]{mx,my}, bottomLeft);
        int topR = dfs(sea, topRight, new int[]{mx + 1,my + 1});
        
        int topL = dfs(sea, new int[]{mx, y2}, new int[]{x1, my + 1});
        int botR = dfs(sea, new int[]{x2,my}, new int[]{mx + 1,y1});
        return topL + topR + botL + botR;
    }
}
