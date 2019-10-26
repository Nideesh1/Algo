class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)return 0;
        int res = 0;
        Comparator<int[]> co = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };
        Comparator<int[]> co1 = new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return a[1] - b[1];
            }
        };
        Arrays.sort(intervals, co);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(co1);
        
        pq.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] t = pq.poll();
            if(t[1] <= intervals[i][0]){
                t[1] = intervals[i][1];
            }else{
                pq.add(intervals[i]);
            }
            pq.add(t);
        }
        return pq.size();
    }
}

//https://leetcode.com/problems/meeting-rooms-ii/
