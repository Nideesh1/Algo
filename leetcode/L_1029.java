class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Comparator co = new Comparator<int[]>() {
            public int compare(int[] a, int[]b){
                return Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
            }
        };
        int n  = costs.length/2;
        int res = 0;
        int countA = 0; int countB = 0;
        Arrays.sort(costs, co);
        
        for(int i = 0; i < costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                System.out.print(costs[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i = 0; i < costs.length; i++){
            if(countA < n && countB < n){
                if(costs[i][0] < costs[i][1]){
                    countA++; res += costs[i][0];
                }
                if(costs[i][0] >= costs[i][1]){
                    countB++; res += costs[i][1];
                }                
            }
            else if(countA < n){
                countA++; res += costs[i][0];
            }
            else if(countB < n){
                countB++; res += costs[i][1];
            }
        }
        
        return res;
    }
}

//Credit To:https://leetcode.com/problems/two-city-scheduling/discuss/278979/Concise-Java-solution-Time%3A-O(nlogn)
//Link:https://leetcode.com/problems/two-city-scheduling/
