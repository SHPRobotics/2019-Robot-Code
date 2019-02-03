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
        
        if(lj.getY() > 0.1 || lj.getY() < -0.1) {

            ld.setSpeed(-lj.getY());

        }

        else {

            ld.setSpeed(0);

        }

        if(rj.getY() > 0.1 || rj.getY() < -0.1) {

            rd.setSpeed(rj.getY());

        }

        else {

            rd.setSpeed(0);

        }

    }    

    
}