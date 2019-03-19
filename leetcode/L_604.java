class StringIterator {

    
    
    List<Character> chars; List<Integer> count; int pos;
    public StringIterator(String compressedString) {
        chars = new ArrayList<>(); count = new ArrayList<>(); pos = 0;
        int i = 0; String str = compressedString;
        while( i < str.length()){
            chars.add(str.charAt(i));
            int j = i + 1;
            while(j < str.length() && Character.isDigit(str.charAt(j))){
                j++;
            }
            count.add(Integer.parseInt(str.substring(i+1, j)));
            i = j;
        }
    }
    
    public char next() {
        if( !hasNext()) return ' ';
        char result = chars.get(pos);
        count.set(pos, count.get(pos) -1);
        if(count.get(pos) == 0) pos++;
        return result;
    }
    
    public boolean hasNext() {
        return pos < chars.size();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 //https://leetcode.com/problems/design-compressed-string-iterator/
