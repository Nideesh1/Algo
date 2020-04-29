class Solution {
    List<Character> list = new ArrayList<>(); 
    public String getHappyString(int n, int k) {
        list.add('a'); list.add('b'); list.add('c');
        int tot = 1;
        int left = n - 1;
        for(int i = 1; i <= left; i++) tot *= 2; tot *= 3;
        if(tot < k) return "";
        
        Set<String> res = new HashSet<>();
        
        dfs(res, n, new char[n], 0);
        List<String> resL = new ArrayList<>(res);
        Collections.sort(resL);
        //System.out.println(resL);
        return resL.get(k-1);
    }
    
    public void dfs(Set<String> res, int n, char[] arr, int p){
        if(p == n){
            //System.out.println(arr);
            String each = new String(arr);
            res.add(each);
        }
        for(int i = p; i < n; i++){
            for(Character c : list){
                if(i == 0 || arr[i-1] != c){
                    arr[i] = c;
                    dfs(res, n, arr, i + 1);

                }
            }
        }
    }
}
