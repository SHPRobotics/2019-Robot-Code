package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Arm {
   
    private XboxController xbox;
    private Victor motor;

    public Arm (XboxController xboxController, Victor armMotor){
        
        
        xbox = xboxController;
        motor = armMotor;


    }

    public void rotate() {

        if (xbox.getY(Hand.kLeft) > .2) {

           motor.setSpeed((xbox.getRawAxis(1)));
        
        }
        else if (xbox.getY(Hand.kLeft) < -.2) {

            motor.setSpeed((xbox.getRawAxis(1)));

        }
        else{

            motor.setSpeed(0);

        }

    }
}