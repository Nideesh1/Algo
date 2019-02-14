class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> tri = new ArrayList<>();
        int totalRow = rowIndex + 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        tri.add(new ArrayList<>(row));
        row.clear();
        
        for(int rowNum = 1; rowNum < totalRow; rowNum++){
            List<Integer> prevRow = tri.get(rowNum  - 1);
            row.add(1);
            for(int j = 1; j < rowNum; j++){
                row.add(prevRow.get(j) + prevRow.get(j-1));
            }
            row.add(1);
            tri.add(new ArrayList<>(row)); row.clear();
        }
        return tri.get(rowIndex);
    }
}

//https://leetcode.com/problems/pascals-triangle-ii/description/
