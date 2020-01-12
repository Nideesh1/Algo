/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    
    int[] x = {-1,0,1,0};
    int[] y = {0,1,0,-1};
    
    public void cleanRoom(Robot robot) {
        Set<String> vis = new HashSet<>();
        dfs(robot, vis, 0, 0, 0);
    }
    
    public void dfs(Robot robot, Set<String> vis, int i, int j, int point){
        String path = i + "-" + j;
        if(vis.contains(path)) return;
        vis.add(path);
        robot.clean();
        
        for(int k = 0; k < 4; k++){
            if(robot.move()){
                
                int ro = i + x[point];
                int co = j + y[point];
                
                dfs(robot, vis, ro, co, point);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            point = (point + 1) %4;
        }
        
    }
}

//https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution/188647
