class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        List<String> l = new ArrayList<>();
        for(String s : cpdomains){
            accept(s, map);
        }
        for(String s : map.keySet()){
            String t = map.get(s) + " " + s;
            l.add(t);
        }
        
        return l;
    }
    
    public void accept(String s, Map<String,Integer> map){
        String[] half = s.split(" ");
        int num = Integer.parseInt(half[0]);

        String[] dom = half[1].split("\\.");
        String str = "";

        for(int i = dom.length - 1; i >= 0; i--){
            str =  dom[i] + str;
            
            int c = map.getOrDefault(str, 0 ) + num;
            map.put(str, c);
                        str = "." + str ;
        }
    }
}

//https://leetcode.com/problems/subdomain-visit-count/
