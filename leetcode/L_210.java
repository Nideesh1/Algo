class Solution {
    int[][] pre;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        pre = prerequisites;
        boolean isPossible = true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] in = new int[numCourses];
        int[] top = new int[numCourses];
        
        for(int i = 0; i < pre.length; i++){
            int s = pre[i][1];
            int d = pre[i][0];
            
            List<Integer> l = map.getOrDefault(s, new ArrayList<>());
            l.add(d);
            map.put(s, l);
            in[d]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        
        int i = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            top[i++] = n;
            
            if(map.containsKey(n)){
                for(Integer nei : map.get(n)){
                    in[nei]--;
                    
                    if(in[nei] == 0){
                        q.add(nei);
                    }
                }
            }
        }
        
        if(i == numCourses){
            return top;
        }
        return new int[0];
    }
}


//https://leetcode.com/problems/course-schedule-ii/solution/
