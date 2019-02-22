class Solution {
    public String reverseVowels(String s) {
        List<Character> list = new ArrayList<>();
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        int n = s.length();
        boolean[] vowelMask = new boolean[n];
        char[] ar = s.toCharArray();
        for(int i = 0; i < n; i++){
            if(vowel.contains(ar[i])){
                list.add(ar[i]);
            }
        }
        
        int j = 0;
        for(int i = n-1; i >= 0; i--){
            if(vowel.contains(ar[i])){
                ar[i] = list.get(j); j++;
            }
        }
        System.out.println(list);
        return new String(ar);
    }
}

//https://leetcode.com/problems/reverse-vowels-of-a-string/discuss/81221/One-pass-Java-Solution-13ms
