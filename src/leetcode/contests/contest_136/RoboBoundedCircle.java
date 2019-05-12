package leetcode.contests.contest_136;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class RoboBoundedCircle {
    RoboBoundedCircle roboBoundedCircle;
    //   N S E W
    //G
    //L
    //R

    char[][] directionMatrix=new char[][]{
            {'N','S','E','W'},
            {'W','E','N','S'},
            {'E','W','S','N'}
    };
    char N=0;
    char S=1;
    char E=2;
    char W=3;

    char G=0;
    char L=1;
    char R=2;



    Robot initial=new Robot();

    private class Robot {
        int x;
        int y;
        char direction;

        Robot() {
            this.x = 0;
            this.y = 0;
            this.direction = 'N';
        }

        public void command(char command){
           char c= directionMatrix[command][this.direction];
           this.direction=c;

        }
    }

    @BeforeEach
    public void init() {
        roboBoundedCircle = new RoboBoundedCircle();
    }

    public void firstTest() {
        boolean result = roboBoundedCircle.isRobotBounded("");
        Assertions.assertEquals(true, result);
    }

    public boolean isRobotBounded(String instructions) {

        return false;
    }
}
