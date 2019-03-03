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
        char[] temp = new char[4];
        int total = 0;
        int pos = 0;
        while(total <= n){
            int leftToN = n - total;
            int read = read4(temp);
            if(read == 0) break;
            total += read;
            for(int i = 0; i < read && leftToN > 0; i++ ,leftToN--){
                buf[pos++] = temp[i];
            }

        }
        return pos;
    }
}

//https://leetcode.com/problems/read-n-characters-given-read4/
