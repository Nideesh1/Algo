class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer,List<Integer>> heightToLength = new HashMap<>();
        for (int[] rec : rectangles) {
            int height = rec[1], length = rec[0];
            List<Integer> lengths = heightToLength.getOrDefault(height, new ArrayList<>());
            lengths.add(length);
            heightToLength.put(height, lengths);
        }
        for (List<Integer> lengths : heightToLength.values()) {
            Collections.sort(lengths);
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
                int num = 0;
                int height = points[i][1], length = points[i][0];
                for (int h = height; h <= 100; h++) {
                    if (heightToLength.containsKey(h)) {
                        num += heightToLength.get(h).size() - binarySearch(heightToLength.get(h), length);
                    }
                }
                res[i] = num;
        }
        return res;
    }
    public int binarySearch(List<Integer> arr, int x) {
        int largest = arr.size();
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x <= arr.get(m) ) {
                r = m - 1;
                largest = m;
            } else {
                l = m + 1;
            }
        }
        return largest;
    }
    
}
