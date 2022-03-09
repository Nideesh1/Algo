class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; // start of window
        int right = 0; // end of window (initially the same as start so we can grab the first char)
        int result = 0; // var to store the length of the longest substring we have found so far
        HashSet<Character> chars = new HashSet(); // hashset to track the chars in the current substring
		// the right hand side of the window must not go over the bounds of the string
        while(right < s.length()) {
            // use the right hand side of the window to get the char, it is initialised to 0 so will pick the first character first
            if(!chars.contains(s.charAt(right))) {
                chars.add(s.charAt(right));
				// if the current set of unique chars is greater in size than the result, that's our longest substring
                result = Math.max(result, chars.size());
				// increment right to increase the window size and grab a new char
                right++;
            } else {
			// once we encounter a char which is already in the hashset we need create a new window starting from left + 1, and reset right to equal left to initialise a new window
                left ++;
                right = left;
				// reset our tracker
                chars.clear();
            }
        }
        return result;
    }
}

//https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1629847/Java-Simple-Sliding-Window-Technique-With-Comments
