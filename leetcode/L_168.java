class Solution {
    public String convertToTitle(int n) {
        Map<Integer,String> map = new HashMap<>();
        for(int i = 97; i <= 97 + 25; i++){
            map.put(i - 96-1, ""+Character.toUpperCase( (char) i));
        }
        if(map.containsKey(n-1)) return map.get(n-1);
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(map.get(--n % 26));
            n /= 26;
        }
        return sb.reverse().toString();

    }
}

//https://leetcode.com/problems/excel-sheet-column-title/
