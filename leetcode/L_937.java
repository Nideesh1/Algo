class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator co = new Comparator<String>(){
            public int compare(String a, String b){
                String[] ar = a.split(" ",2);
                String[] br = b.split(" ",2);
                
                boolean alet = false;
                boolean blet = false;                
                for(char c : ar[1].toCharArray()){
                    if(Character.isLetter(c))
                    {alet = true; break;}
                }
                for(char c : br[1].toCharArray()){
                    if(Character.isLetter(c))
                    {blet = true; break;}
                }
                if(alet && blet){
                    if(ar[1].equals(br[1])){
                        return ar[0].compareTo(br[0]);
                    }else{
                        return ar[1].compareTo(br[1]);
                    }
                }else{
                    if(alet && !blet) return -1;
                    if(!alet && blet) return 1;
                }
    
                return 0;
            }
        };
        Arrays.sort(logs, co);
        return logs;
    }
}

//https://leetcode.com/problems/reorder-log-files/description/
