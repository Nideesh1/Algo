class Solution {
    public List<String> letterCasePermutation(String S) {
        
        List<String> l = new ArrayList<>();
        if(S.equals("")) l.add("");
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            char cup = Character.toUpperCase(c);
            char clo = Character.toLowerCase(c);
            if(l.size() == 0){
                if(Character.isUpperCase(c)){
                    l.add("" + c); l.add("" + clo);
                }
                else if(Character.isLowerCase(c)){
                    l.add("" + c); l.add("" + cup);
                }
                else if (Character.isDigit(c)){
                    l.add("" + c);
                }
            }else{
                
                if (Character.isDigit(c)){
                   for(int j = 0; j < l.size(); j++){
                       l.set(j, l.get(j) + c);
                   }
                }
                else if(Character.isUpperCase(c)){
                    

                    l.addAll(l);
                   for(int j = 0; j < l.size()/2; j++){
                       l.set(j, l.get(j) + c);
                   }
                   for(int j = l.size()/2; j < l.size(); j++){
                       l.set(j, l.get(j) + clo);
                   }
                    
                    
                }
                else if(Character.isLowerCase(c)){
                    l.addAll(l);
                   for(int j = 0; j < l.size()/2; j++){
                       l.set(j, l.get(j) + c);
                   }
                   for(int j = l.size()/2; j < l.size(); j++){
                       l.set(j, l.get(j) + cup);
                   }                                        
   
                }
                
                
            }
        }
        
        return l;
    }
}

//https://leetcode.com/problems/letter-case-permutation/
