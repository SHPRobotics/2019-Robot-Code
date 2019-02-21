 package frc.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

public class Hatch {

    private Victor motor;
    private XboxController xbox;
    private DigitalInput hatchLimitBack = new DigitalInput(7);

    public Hatch (XboxController xboxController, Victor hatchMotor){
        
        xbox = xboxController;
        motor = hatchMotor;

    }

    public void rotate(){

        if (xbox.getAButton()){

            motor.setSpeed(0.5);
       
        }
        else if (xbox.getBButton()){

            motor.setSpeed(-.5);

        }
        else {

            motor.setSpeed(0);

        }

    }

    public void limitedRotation(){

        if (hatchLimitBack.get()){

            rotate();

        }
        else if (!hatchLimitBack.get()){

            if(xbox.getBButton()) {

                motor.setSpeed(-.5);

            }

        }
        else{

            motor.setSpeed(0);

        }

    }
    
}