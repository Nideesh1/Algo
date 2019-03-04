class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //System.out.println(licensePlate);
        Map<Character,Integer> map = new HashMap<>();
        for(char c : licensePlate.toCharArray()){
            if(Character.isLetter(c)){
            int t = map.getOrDefault(Character.toLowerCase(c), 0) + 1; map.put(Character.toLowerCase(c),t);
            }
        }
        List<String> l = new ArrayList<>();
        
        loop:
        for(String s : words){
            Map<Character,Integer> temp = create(s);
            //System.out.println(temp);
            for(Character c : map.keySet()){
                if(!temp.containsKey(c)){
                    continue loop;
                }
                if(temp.get(c) < map.get(c)){
                    continue loop;
                }
            }
            l.add(s);
        }
        
        Comparator co = new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        };
        
        Collections.sort(l, co);

        
        return l.get(0);
    }
    
    public Map<Character,Integer> create(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
            int t = map.getOrDefault(Character.toLowerCase(c), 0) + 1; map.put(Character.toLowerCase(c),t);
            }
        }  
        return map;
    }
}

//https://leetcode.com/problems/shortest-completing-word/
