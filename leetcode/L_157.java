/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int read = 0;
        int total = 0;
        char[] temp;
        int i = 0;
        while(total*4 < n){
            temp = new char[4];
            read4(temp);
            total++;
            for(char c : temp){
                if((Character.isLetter(c) || Character.isDigit(c)) && read < n){
                    //System.out.print(c + " ");
                    read++;
                    buf[i++] = c;
                }
            }
        }
        return read;
    }
}

//https://leetcode.com/problems/read-n-characters-given-read4/
