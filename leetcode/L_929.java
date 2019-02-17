class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s : emails){
            String[] em = s.split("@");
            em[0] = local(em[0]);
            //System.out.println(Arrays.toString(em));
            set.add(em[0] + "@" + em[1]);
        }
        return set.size();
    }
    
    public String local(String str){
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character i : arr){
            if(i == '.'){continue;}
            if(i == '+'){break;}
            sb.append(i);
        } return sb.toString();
    }
}

//https://leetcode.com/problems/unique-email-addresses/description/
