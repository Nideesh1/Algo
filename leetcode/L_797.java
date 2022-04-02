class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(graph, 0, list, res);
        return res;
    }
    public void dfs(int[][] graph, int cur, LinkedList<Integer> list, List<List<Integer>> res) {
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int nei : graph[cur]) {
            list.addLast(nei);
            dfs(graph, nei, list, res);
            list.removeLast();
        }
    }
}

class Solution {
    Map<Integer,List<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(0,graph);
    }
    public List<List<Integer>> dfs(Integer cur, int[][] graph) {
        if (memo.containsKey(cur)) return memo.get(cur);
        
        List<List<Integer>> res = new ArrayList<>();
        if (cur == graph.length - 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(cur);
            res.add(new ArrayList<>(temp));
            return res;
        }
        for (int nei : graph[cur]) {
            for (List<Integer> neiList : dfs(nei, graph)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(cur);
                temp.addAll(neiList);
                res.add(temp);
            }
        }
        memo.put(cur, res);
        return res;
    }
}
