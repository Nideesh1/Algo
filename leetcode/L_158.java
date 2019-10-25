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
    char[] temp = new char[4];
    int temp_p = 0;
    int temp_c = 0;
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n){
            if(temp_p == temp_c){
                temp_p = 0;
                temp_c = read4(temp);
                if(temp_c == 0) break;
            }
            while(i < n && temp_p < temp_c){
                buf[i++] = temp[temp_p++];
            }
        }
        return i;
    }
}

//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49598/A-simple-Java-code
