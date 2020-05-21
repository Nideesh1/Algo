class Solution {
    public int numPoints(int[][] points, int r) {
        int res = 1; int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double x1 = points[i][0]; 
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];
                
double d = dist(x1, y1, x2, y2);
                if(d > r*2) continue;
                double midX = (x1+x2)/2; double midY = (y1+y2)/2;
                
                double pythag = Math.sqrt(r * r - d * d / 4);
                midX += pythag * (y2-y1) / d;
                midY -= pythag * (x2 - x1) / d;
                int count = 0;
                for(int[] p : points){
                    double px = p[0]; double py = p[1];
                    if(dist(midX, midY, px, py) <= r +1e-6){
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
    
    public double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1 - x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}
//Credit https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/discuss/636372/JavaC%2B%2BPython-POJ-1981