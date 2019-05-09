class Solution {
    public int countCornerRectangles(int[][] grid) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int[] row : grid){
            for(int c1 = 0; c1 < row.length; c1++){
                if(row[c1] == 1){
                    for(int c2 = c1 + 1; c2 < row.length; c2++){
                        if(row[c2] == 1){
                            int pos = c1 * 200 + c2;
                            int seen = map.getOrDefault(pos, 0);
                            res += seen;
                            map.put(pos, seen+1);
                        }
                    }
                }
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/number-of-corner-rectangles/
