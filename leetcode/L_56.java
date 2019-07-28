class Solution {
    int[][] res = null;
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[][]{};
        Stack<int[]> stk = new Stack<>();
        Interval comp = new Interval();
        Arrays.sort(intervals, comp);
        // for(int[] in : intervals){
        // System.out.print(Arrays.toString(in));            
        // }
        stk.push(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(overlap(stk.peek(), intervals[i])){
                int[] t = stk.pop();
                t[1] = Math.max(t[1], intervals[i][1]);
                stk.push(t);
            }else{
                stk.push(intervals[i]);
            }
        }
        res = new int[stk.size()][2];
        for(int i = res.length-1; i >= 0; i--){
            res[i] = stk.pop();
        }
        //System.out.println(stk.size());
        return res;
    }
    public boolean overlap(int[] a, int[] b){
        int front = Math.max(a[0], b[0]);
        int back = Math.min(a[1], b[1]);
        return back - front >= 0 ? true : false;
    }
}

class Interval implements Comparator<int[]>{
    public int compare(int[] one, int[] two){
        return one[0] - two[0];
    }
}

//https://leetcode.com/problems/merge-intervals/
//O(nlogn), where n is the length of intervals
