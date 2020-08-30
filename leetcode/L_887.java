//TLE
class Solution {
    public int superEggDrop(int K, int N) {
        int eggs = K;
        int floors = N;
        return dfs(eggs, floors);
    }
    public int dfs(int eggs, int floors){
        if(floors <= 1) return floors;
        if(eggs == 1) return floors;
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= floors; i++){
                
            int one = dfs(eggs - 1, i - 1); // below floor i
            int two = dfs(eggs, floors - i);// above floor i
            
            res = Math.min(res, Math.max(one, two));
            
        }
        return res + 1;
    }
}

class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int superEggDrop(int K, int N) {

        int eggs = K; int floors = N;
        return dfs(eggs, N);
    }
    public int dfs(int eggs, int floors){
        if(floors <= 1) return floors;
        if(eggs == 1) return floors;
        String key = eggs + "," + floors;
        if(map.containsKey(key)) return map.get(key);
        
        int l = 1; int r = floors; int res = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l)/2;
            int one = dfs(eggs - 1, mid-1);
            int two = dfs(eggs, floors - mid);
            res = Math.min(res, Math.max(one, two) + 1);
            if(one == two){
                break;
            }else if (one < two){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        map.put(key, res);
        return res;
    }
}
