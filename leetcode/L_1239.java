class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        dfs(new StringBuilder(), arr, 0);
        return res;
    }
    public void dfs(StringBuilder sb, List<String> arr, int p) {
        res = Math.max(sb.length(), res);
        if (p >= arr.size()) return;
        //System.out.println(sb);
        for (int i = p; i < arr.size(); i++) {
            if (duplicate(sb, arr.get(i))) continue;
            //int len = sb.length();
            sb.append(arr.get(i));
            dfs(sb, arr, i + 1);
            //sb.setLength(len);
            sb.delete(sb.length() - arr.get(i).length(), sb.length());
        }
    }
    
    
    public boolean duplicate (StringBuilder sb, String str) {
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            temp.add(c);
            if(sb.indexOf(c + "") != -1) return true;
        }
        //System.out.println(temp);
        return temp.size() != str.length() ? true : false;
    }
}
