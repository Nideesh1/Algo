class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0), v = eq.get(1);
            double val = values[i];
            
            Map<String,Double> m1 = map.getOrDefault(u, new HashMap<>());
            m1.put(v, val);
            map.put(u, m1);
            
            Map<String,Double> m2 = map.getOrDefault(v, new HashMap<>());
            m2.put(u, 1 / val);
            map.put(v, m2);            
        }
//        System.out.println(map);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)) {
                res[i] = -1;
            } else if (dividend.equals(divisor)) {
                res[i] = 1;
            } else {
                Set<String> set = new HashSet<>();
                res[i] = dfs(map, set, dividend, divisor, 1.0);
            }
        }
        return res;
    }
    public double dfs(Map<String,Map<String,Double>> map, Set<String> set, String cur, String divisor, double val) {
        double res = -1;
        set.add(cur);
        
        if (divisor.equals(cur)) {
            res = val;
        } else {
            for (String key : map.get(cur).keySet()) {
                    if (set.contains(key)) {
                        continue;
                    }
                    double temp = dfs(map, set, key, divisor, val * (map.get(cur).get(key)));
                    if (temp != -1) {
                        res = temp;
                        break;
                    }
            }
        }
        
        set.remove(cur);
        return res;
    }
}
