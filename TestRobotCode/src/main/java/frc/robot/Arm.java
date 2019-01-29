package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Arm {
   
    private XboxController xbox;
    private Victor motor;

    public Arm (XboxController x, Victor v){
        
        
        xbox = x;
        motor = v;


    }

    public void rotate() {

        if (xbox.getY(Hand.kLeft) > .1) {

           motor.setSpeed((xbox.getY(Hand.kLeft)));
        
        }
        else if (xbox.getY(Hand.kLeft) < -.1) {

            motor.setSpeed(-(xbox.getTriggerAxis(Hand.kLeft)));

        }
        else{

            motor.setSpeed(0);

        }

    }
}