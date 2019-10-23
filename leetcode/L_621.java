class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char t : tasks){
            map[t - 'A']++;
        }
        Arrays.sort(map);
        int res = 0;
        while(map[25] > 0){
            int i = 0;
            
            for(int j = 25; i <= n ; j--)
            {
                if(map[25] == 0 )break;
                
                if(j >= 0 && map[j] > 0 ){map[j]--;}
                i++;
                res++;
            }

            Arrays.sort(map);
        }
        return res;
    }
}
//https://leetcode.com/problems/task-scheduler/
//https://leetcode.com/articles/task-scheduler/
