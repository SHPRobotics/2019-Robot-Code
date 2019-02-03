package frc.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Hatch {

    private Victor motor;
    private XboxController xbox;

    public Hatch (XboxController xboxController, Victor hatchMotor){
        
        xbox = xboxController;
        motor = hatchMotor;

    }

    public void rotate(){

        if (xbox.getTriggerAxis(Hand.kRight) > .1){

            motor.setSpeed(0.5*(xbox.getTriggerAxis(Hand.kRight)));
       
        }
        else if (xbox.getTriggerAxis(Hand.kLeft) > .1){

            motor.setSpeed(-.5*(xbox.getTriggerAxis(Hand.kLeft)));

        }
        else{

            motor.setSpeed(0);

        }

    }
    
}