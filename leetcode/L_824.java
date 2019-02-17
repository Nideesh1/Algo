class Solution {
    public String toGoatLatin(String S) {
        String[] sArr = S.split(" ");
        Set<Character> set = new HashSet<>(); set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u'); 
        int a = 1;
        for(int i = 0; i < sArr.length; i++){
            StringBuilder sb = new StringBuilder(sArr[i]);
            
            char car = Character.toLowerCase(((Character) sArr[i].charAt(0) ));
            //System.out.println(car);
            
            if(set.contains(car)){
                sb.append("ma");
            }else{
                char front = sb.charAt(0); sb.deleteCharAt(0); sb.append(front); sb.append("ma");
            }
            sArr[i] = appendA(sb.toString() , a); a++;
        }
        S = String.join(" ", sArr);
        //System.out.println(S);
        return S;
    }
    
    public String appendA(String s, int i){
        StringBuilder sb = new StringBuilder(s);
        while(i != 0){
            sb.append('a'); i--;
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/goat-latin/description/
