class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        Map<Character,Character> map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++){
            if(!map.containsKey(str1.charAt(i))){
                map.put(str1.charAt(i), str2.charAt(i));
            }else{
                if(map.get(str1.charAt(i)) != str2.charAt(i)) return false;
            }
        }
        System.out.println(map);

        return new HashSet<>(map.values()).size() < 26;
    }
}

//https://leetcode.com/problems/string-transforms-into-another-string/
