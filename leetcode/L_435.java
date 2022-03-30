class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> co = new Comparator<>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        };
        Arrays.sort(intervals, co);
        //System.out.println(Arrays.deepToString(intervals));
        Stack<int[]> stk = new Stack<>();
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {

            if (stk.size() == 0 || stk.peek()[1] <= intervals[i][0]) {
                stk.push(intervals[i]);
            } else {
                res++;
            }
            //System.out.println(res + " " + Arrays.toString(intervals[i]) + " " + stk.size());
        }
        return res;
    }
}
