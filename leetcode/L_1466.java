class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        Set<String> edgeDir = new HashSet<>();
        for (int[] edge : connections) {
            int u = edge[0],  v = edge[1];
            List<Integer> l1 = map.getOrDefault(u, new ArrayList<>());
            l1.add(v);
            map.put(u, l1);
            List<Integer> l2 = map.getOrDefault(v, new ArrayList<>());
            l2.add(u);
            map.put(v, l2);
            edgeDir.add(u + "->" + v);
        }
        // System.out.println(map);
        // System.out.println(edgeDir);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            vis.add(cur);
            //System.out.println(cur);
            if (map.containsKey(cur)) {
                for (Integer nei : map.get(cur)) {
                    if (vis.add(nei)) {
                        String edge = cur + "->" + nei;
                        if (edgeDir.contains(edge)) res++;
                        q.add(nei);
                    }
                }                
            }

        }
        return res;
    }
}
