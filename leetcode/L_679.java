class Solution {
    
    boolean res = false;
    double eps = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int n : nums) list.add((double) n);
        dfs(list);
        return res;
    }
    public void dfs(List<Double> list){
        if(res)return;
        if(list.size() == 1){
            if(Math.abs(list.get(0) - 24) < eps){
                res = true;
            }
            return;
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                
                List<Double> next = new ArrayList<>();
                Double p1 = list.get(i); 
                Double p2 = list.get(j);
                
                next.addAll(Arrays.asList(p1-p2, p2-p1, p1+p2, p1*p2));
                if(Math.abs(p1) > eps) next.add(p2/p1);
                if(Math.abs(p2) > eps) next.add(p1/p2);
                
                list.remove(i);
                list.remove(j);
                
                for(Double d : next){
                    list.add(d);
                    dfs(list);
                    list.remove(list.size() - 1);
                }
                
                list.add(j, p2);
                list.add(i, p1);
            }
        }
    }
}

//https://leetcode.com/problems/24-game/discuss/107673/JAVA-Easy-to-understand.-Backtracking.
