class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> master = new HashMap<>();
        int res = 0;
        for (char c : chars.toCharArray()) {
            master.put(c, master.getOrDefault(c, 0) + 1);
        }
        //System.out.println(map);
        for (String w : words) {
            Map<Character,Integer> map = new HashMap<>(master);
            boolean good = true;
            for (char c : w.toCharArray()) {
                if (map.containsKey(c) && map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                } else {
                    good = false;
                    break;
                }
            }
            if (good) {
                //System.out.println(w);
                res += w.length();
            }
        }
        
        return res;
    }
}
