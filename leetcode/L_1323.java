class Solution {
    public int maximum69Number (int num) {
        if(num == 6) return 9;
        char[] str = Integer.toString(num).toCharArray();
        int ind = -1;
        for(int i = 0; i < str.length; i++){
            if(str[i] == '6') {ind = i; break;}
        }
        //System.out.println(ind);
        if(ind == -1) return num;
        str[ind] = '9';
        return Integer.valueOf(new String(str));
    }
}

