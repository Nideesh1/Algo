class Solution {
    public String defangIPaddr(String address) {
        String[] ar = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(String a : ar) sb.append(a).append("[.]");
        sb.setLength(sb.length() - 3);
        return sb.toString();
    }
}