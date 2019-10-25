class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> co = new Comparator<int[]>(){
            public int compare(int[] one, int[] two){
                return one[0] - two[0];
            }
        };
        Arrays.sort(intervals, co);
        for(int i = 1; i < intervals.length; i++){
            if(overlap(intervals[i-1], intervals[i])) return false;
        }
        return true;        
    }
    public boolean overlap(int[] one, int[] two){
        int front = Math.max(one[0], two[0]);
        int back = Math.min(one[1], two[1]);
        return back > front;
    }
}

//https://leetcode.com/problems/meeting-rooms/
