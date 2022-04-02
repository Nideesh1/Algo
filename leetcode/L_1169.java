class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String,Map<Integer,String>> map = new HashMap<>();
        //  name        time    city
        List<String> res = new ArrayList<>();
        for (String t : transactions) {
            String[] ar = t.split(",");
            String name = ar[0];
            Integer time = Integer.parseInt(ar[1]);
            String city = ar[3];
            Map<Integer,String> temp = map.getOrDefault(name, new HashMap<>());
            if (temp.containsKey(time)) {
                temp.put(time, "Invalid");
            } else {
                temp.put(time, city);
            }
            map.put(name, temp);
        }
        //System.out.println(map);
        for (String t : transactions) {
            String[] ar = t.split(",");
            String name = ar[0];
            Integer time = Integer.parseInt(ar[1]);
            Integer amount = Integer.parseInt(ar[2]);
            String city = ar[3];
            if (amount > 1000) {
                res.add(t);
            } else {
                Map<Integer,String> curTrans = map.get(name);
                for (int i = time - 60; i <= time + 60; i++) {
                    if ((curTrans.containsKey(i) && !curTrans.get(i).equals(city)) || (i == time && curTrans.get(i).equals("Invalid"))) {
                        res.add(t);
                        break;
                    }
                }
            }
        }
        return res;
    }
}

