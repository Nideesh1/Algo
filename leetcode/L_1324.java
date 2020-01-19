class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        TreeMap<Integer,String> map = new TreeMap<>();
        String[] ar = s.split(" ");
        int max = 0;
        for(int i = 0; i < ar.length; i++){
            ar[i] = ar[i].trim();
            max = Math.max(max, ar[i].length());
        }
        for(int i = 0; i < ar.length; i++){
            for(int j = 0; j < max; j++){
                String del = "";
                for(int k = 0; k < i; k++){
                    del += " ";
                }
                
                String v = map.getOrDefault(j, del);
                v += j >= ar[i].length() ? " " : ar[i].charAt(j);
                map.put(j, v);
            }
        }
        //System.out.println(map);
        for(int i : map.keySet()){
            res.add(trimEnd(map.get(i)));
        }
        //System.out.println(trimEnd("   T-  "));
        return res;
    }
    
    public String trimEnd(String str){
        char[] ar = str.toCharArray();
        int idx = ar.length - 1;
        while(ar[idx] == ' '){
            idx--;
        }
        return str.substring(0, idx + 1);
    }
}
