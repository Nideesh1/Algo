class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            
            public int compare(String log1, String log2){
                String[] ar1 = log1.split(" ", 2);
                String[] ar2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(ar1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(ar2[1].charAt(0));
                
                //if neither is digit. they are both letter
                if (!isDigit1 && !isDigit2){
                    int c = ar1[1].compareTo(ar2[1]);
                    if( c != 0 ){
                        return c;
                    }
                    return ar1[0].compareTo(ar2[0]);
                }
                
                return isDigit1 ? ( isDigit2 ? 0 : 1 ) : -1;
            }
            
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}

//https://leetcode.com/problems/reorder-log-files/description/
