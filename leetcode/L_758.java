class Solution {
    public String boldWords(String[] words, String S) {
        int N = S.length();
        //if mask is false, the char shouldnt be bold
        boolean[] mask = new boolean[N];
        
        //For each space in the mask
        for (int i = 0; i < N; ++i)
            
            //Labeled for loop. This one is called search. 
            for (String word: words) search: {
                
                //K is pointer to word[i]
                for (int k = 0; k < word.length(); ++k)
                    
                    //Checking if the word is completely a substring of S
                    if (k+i >= S.length() || S.charAt(k+i) != word.charAt(k))
                        break search;

                //if the test passes, then mask is gonna be true for the chars of word
                // the j < i + word.length() is for absolute position 
                for (int j = i; j < i+word.length(); ++j)
                    mask[j] = true;
            }
        System.out.println(Arrays.toString(mask));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            // mask[i-1] must be false and mask[i] must be true
            if (mask[i] && (i == 0 || !mask[i-1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            // mask[i] must be true and mask[i+1] must be false
            if (mask[i] && (i == N-1 || !mask[i+1]))
                ans.append("</b>");
        }
        return ans.toString();
    }
}
//https://leetcode.com/problems/bold-words-in-string/description/
