class Solution {
    public String frequencySort(String s) {
        char[] ar = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : ar) map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < map.get(list.get(i)); k++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
