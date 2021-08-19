package effort_2021;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class RobotRoomCleaner {
    Robot robot;
    Set<Pair<Integer,Integer>> visited;
    int[][] directions= {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        this.robot=robot;
        this.visited=new HashSet<>();
        backtrack(0,0,0);
    }

    private void backtrack(int row, int col, int d) {
        visited.add(new Pair<>(row,col));
        robot.clean();
        for (int i = 0; i <4 ; i++) {
            int newD=(d+i)%4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if(!visited.contains(new Pair<>(newRow,newCol)) && robot.move()){
                backtrack(newRow,newCol,newD);
                goBack();
            }
            robot.turnRight();
        }

    }

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
