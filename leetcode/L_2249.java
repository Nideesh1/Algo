class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for (int[] circle : circles) {
            help(circle, set);
        }
        return set.size();
    }
    public void help (int[] arr, Set<String> set) {
        int cx = arr[0], cy = arr[1], rad = arr[2];
        int x1 = cx - rad, y1 = cy + rad;
        //System.out.println("x1 " + x1 + " y1 " + y1);
        for (int i = x1; i <= x1 + rad + rad; i++) {
            for (int j = y1; j >= y1 - rad - rad; j--) {
                //System.out.println("i/x is " + i + " j/y is " + j);
                double dist = dist(i,j,cx,cy);
                if (dist <= (double) rad) {
                    //System.out.println(i + "," + j);
                    set.add(j + "," + i);
                }
            }
        }
    }
    public double dist (int x1, int y1, int x2, int y2) {
        int X = (x2 - x1) * (x2 - x1);
        int Y = (y2 - y1) * (y2 - y1);
        return Math.sqrt(X + Y);
    }
}
