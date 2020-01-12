/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int n=schedule.size();
        List<Interval> time=mergeSort(schedule, 0, n-1);
        List<Interval> free=new ArrayList<>();

        
        int end = time.get(0).end;
        for(int i = 1; i < time.size(); i++){
            
            if(time.get(i).start > end){
                free.add(new Interval(end, time.get(i).start));
            }
            end = Math.max(end, time.get(i).end);
            
        }
        
        return free;
    }
    
    public List<Interval> mergeSort(List<List<Interval>> schedule, int i, int j){
        if(i >= j) return schedule.get(i);
        int m = (i+j)/2;
        
        List<Interval> l = mergeSort(schedule, i, m);
        List<Interval> r = mergeSort(schedule, m+1, j);
        return merge(l, r);
    }
    
    public List<Interval> merge(List<Interval> l, List<Interval> r){
        List<Interval> res = new ArrayList<>();
        int m = l.size();
        int n = r.size();
        
        int i = 0; int j = 0;
        while(i < m || j < n){
            
            if(i == m) res.add(r.get(j++));
            else if(j == n) res.add(l.get(i++));
        
            else if(l.get(i).start < r.get(j).start){
                res.add(l.get(i++));
            }else{
                res.add(r.get(j++));
            }
            
        
        }
        
        return res;
    }
}

//https://leetcode.com/problems/employee-free-time/discuss/113122/Merge-Sort-O(nlgK)-(Java)
