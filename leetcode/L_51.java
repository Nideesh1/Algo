class Solution {
    
    Set<Integer> col = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, n);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> list, int row, int n){
        if(row == n){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < n; i++){
            
            if(col.contains(i) || diag1.contains(row + i) ||
              diag2.contains(row - i)) continue;
            
            char[] ar = new char[n];
            Arrays.fill(ar, '.');
            ar[i] = 'Q';
            String rowString = new String(ar);
            
            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);
            
            dfs(res, list, row + 1, n);
            
            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
//https://leetcode.com/problems/n-queens/discuss/19804/Share-my-JAVA-DFS-solution-very-easy-to-understand
