class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList();
        List<StringBuilder> current = new ArrayList();
        int numOfLetters = 0;
        
        for(String word : words) {
            StringBuilder w = new StringBuilder(word);
            
            if(numOfLetters + w.length() + current.size() > maxWidth) {
                
                for(int i = 0; i < (maxWidth - numOfLetters); i++) {
                    if(current.size() == 1) {
                      current.get(0).append(" ");
                    } else {
                      current.get(i%(current.size() - 1)).append(" ");  
                    }
                }
                
                result.add(String.join("", current));
                
                current.clear();
                numOfLetters = 0;
            } 
              
            current.add(w);
            numOfLetters += w.length();
            
        }
    
        result.add(String.format("%-" + maxWidth + "s", String.join(" ", current)));
        
        return result;
    }
}

//https://leetcode.com/problems/text-justification/discuss/24891/Concise-python-solution-10-lines./303690
//https://medium.com/better-programming/formatting-strings-with-java-2281d40accce
