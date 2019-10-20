class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int s1 = 0; int n1 = slots1.length;
        int s2 = 0; int n2 = slots2.length;
        List<Integer> res = new ArrayList<>();
        
        Comparator co = new Comparator<int[]>(){
          public int compare(int[] a, int[] b){
              return a[0] - b[0];
          }  
        };
        Arrays.sort(slots1, co);
        Arrays.sort(slots2, co);        
        while(s1 < n1 && s2 < n2){
            if(overlap(slots1[s1], slots2[s2]) >= duration){

                    res.add(Math.max(slots1[s1][0], slots2[s2][0]));
                    res.add(res.get(0) + duration);
                    return res;                    
                

            }else{
                if(slots1[s1][1] < slots2[s2][1]){
                    s1++;
                }else{
                    s2++;
                }
            }
        }
        return res;
    }
    
    public int overlap(int[] a, int[] b){
        int front = Math.max(a[0], b[0]);
        int back = Math.min(a[1], b[1]);
        return back - front;
    }
}
//https://leetcode.com/problems/meeting-scheduler/
