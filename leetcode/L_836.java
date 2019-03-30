class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        return overlap(rec1[0], rec1[2], rec2[0], rec2[2]) &&
                          overlap(rec1[1], rec1[3], rec2[1], rec2[3])  ;
        
        
    }
    
    public boolean overlap(int i1, int i2, int i3, int i4){
        int first = Math.max(i1, i3);
        int end = Math.min(i2, i4);
        return first < end;
    }
}

//https://leetcode.com/problems/rectangle-overlap/
