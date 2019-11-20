class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ar = s.split("\\s");
        for(String st : ar){
            st.trim();
        }
        String res = "";
        for(int i = ar.length-1; i >= 0; i--){
            if(i != 0 && !ar[i].equals("") ){
                res += ar[i] + " ";
            }else if(!ar[i].equals(" ") ){
                res += ar[i];
            }
        }
        return res;
    }
}

class Solution {
    public String reverseWords(String s) {
        //reverse whole word
        char[] a = s.toCharArray();
        rev(a, 0, s.length() - 1);
        System.out.println(Arrays.toString(a));
        //rev each word
        revEach(a);
        System.out.println(Arrays.toString(a));
        
        //clean emptys
        return clean(a);
    }
    public String clean(char[] a){
        int n = a.length;
        int i = 0; int j = 0;

        while(j < n){
            while(j < n && a[j] == ' ')j++;
            while(j < n && a[j] != ' ')a[i++] = a[j++];
            while(j < n && a[j] == ' ')j++;
            if(j < n) a[i++] = ' ';
        }
        return new String(a).substring(0, i);
    }
    
    
    public void revEach(char[] a){
        int i = 0; int j = 0;
        while(j <= a.length){
            if(j == a.length || a[j] == ' '){
                rev(a, i, j-1);
                i = j + 1;
            }
            j++;
        }
    }
    
    public void rev(char[] a, int s, int e){
        while(s <= e){
            char c = a[s];
            a[s] = a[e];
            a[e] = c;
            s++; e--;
        }
    }
}


//https://leetcode.com/problems/reverse-words-in-a-string/
