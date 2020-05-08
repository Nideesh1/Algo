class Solution {
    public String getHappyString(int n, int k) {
        List<String> tot = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'b', 'c'};
        dfs(tot, sb, arr, n);
        return tot.size() >= k ? tot.get(k- 1) : "";
    }

    public void dfs(List<String> tot, StringBuilder sb, char[] arr, int n){
        if(sb.length() == n){
            tot.add(sb.toString()); return;
        }
        for(int i = 0; i < arr.length; i++){
            if(sb.length() > 0 && arr[i] == sb.charAt(sb.length() - 1)) continue;
            sb.append(arr[i]);
            dfs(tot, sb, arr, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}