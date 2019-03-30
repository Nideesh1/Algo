//area of triangle =  | ax ( by - cy) + bx ( cy - ay) + cx ( ay - by ) / 2 |
class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        int n = points.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++  ){
                for(int k = j+1; k < n; k++){
                    
                    max = Math.max(max, area(points[i], points[j], points[k]));
                    
                }
            }
        }
        return max;
    }
    
    public double area(int[] a, int[] b, int[] c){
        double res = 0;
        res = Math.abs( 0.5 * ( (a[0]*(b[1]-c[1])) +  (b[0]*(c[1]-a[1])) + (c[0]*(a[1]-b[1]) ) ) ) ;
      return res;
    }
}
