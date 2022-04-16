class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length, i = 0;
        
        
        //makes sense, if current intervals closes before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        //we are expanding the newInterval, and will continue to do so as long
        //as it's end occurs after current i interval opens. keep expanding
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while (i < n) list.add(intervals[i++]); 
        return list.toArray(new int[0][2]);
    }
}
