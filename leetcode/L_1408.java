class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Comparator<String> co = (
        (String a, String b) -> a.length() - b.length()
        );
        Arrays.sort(words, co);
        
        System.out.println(Arrays.toString(words));     
        for(int i = 0; i < words.length; i++){
            
            String cur = words[i];
            int end = words.length - 1;
            
            while(i < end){
                if(words[end--].indexOf(cur) != -1){
                    res.add(cur); break;
                }
            }
            
        }
        
        return res;
    }
}
