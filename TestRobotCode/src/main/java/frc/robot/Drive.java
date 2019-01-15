package frc.robot;

import edu.wpi.first.wpilibj.*;

public class Drive {

    //Private Variables for motors and joysticks 

    Joystick lj;
    Joystick rj;
    Spark ld; //ld stands for "Left Drive" which is the left drive motor
    Spark rd; //rd is the right drive motor

    public Drive(Joystick leftJoystick, Joystick rightJoystick, Spark leftSpark, Spark rightSpark){

        lj = leftJoystick;
        rj = rightJoystick;
        ld = leftSpark;
        rd = rightSpark;

    }
    
    public void linearDrive() {
        
        ld.setSpeed(-lj.getY());
        rd.setSpeed(rj.getY());

    }

    

}