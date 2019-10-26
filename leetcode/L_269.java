class Solution {
    Map<Character,List<Character>> map = new HashMap<>();
    Map<Character,Integer> ind = new HashMap<>();
    Set<Character> let = new HashSet<>();
    public String alienOrder(String[] words) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < words.length; i++){
            let(words[i]);
        }  
        //build map
        for(int i = 1; i < words.length; i++){
            build(words[i-1], words[i]);
        }
        //build ind
        for(char c : let){
            if(!ind.containsKey(c)){
                q.add(c);
            }
        }

        String res = "";
        while(!q.isEmpty()){
            char c = q.poll();
            
            if(!ind.containsKey(c) || (ind.containsKey(c) && ind.get(c) == 0)){
                res += c;
            }
            for(char nei : map.getOrDefault(c, new ArrayList<>())){
                ind.put(nei, ind.get(nei) - 1);
                if(ind.get(nei) == 0){q.add(nei);}
            }
            
        }
        return res.length() == let.size() ? res : "";
    }
    
    public void let(String s){
        for(char c : s.toCharArray()) let.add(c);
    }
    
    public void build(String one, String two){
        for(int i = 0;  i < Math.min(one.length(), two.length()); i++){
            char o = one.charAt(i);
            char t = two.charAt(i);  
            if(o == t)continue;
            
            List<Character> l = map.getOrDefault(o, new ArrayList<>());
            l.add(t); 
            ind.put(t, ind.getOrDefault(t,0)+1);
            //ind.put(o, ind.getOrDefault(t,0)+0);            
            map.put(o, l);
            break;
        }
    }
}

//https://leetcode.com/problems/alien-dictionary/
