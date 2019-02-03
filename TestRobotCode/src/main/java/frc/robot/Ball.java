package frc.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Ball {

    private XboxController xbox;
    private Victor motor;

    public Ball (XboxController xboxController, Victor ballMotor) {

        xbox = xboxController;
        motor = ballMotor;

    }

    public void rotate(){

        if (xbox.getY(Hand.kRight) > .1) {

            motor.setSpeed(0.75*(xbox.getY(Hand.kRight)));
         
         }
         else if (xbox.getY(Hand.kRight) < -.1) {
 
             motor.setSpeed(0.75*(xbox.getY(Hand.kRight)));
 
         }
         else{
 
             motor.setSpeed(0);
 
         }

    }
    
}