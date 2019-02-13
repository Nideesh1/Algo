/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(int i = 1; i < intervals.length ; i++){
            Interval i1 = intervals[i-1];
            Interval i2 = intervals[i];
            if(i1.end > i2.start){return false;}
        }
        return true;
    }
}

//https://leetcode.com/problems/meeting-rooms/description/
