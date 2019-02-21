package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.DigitalInput;

public class Arm {
   
    private XboxController xbox;
    private Victor motor;
    private DigitalInput armLimitUp = new DigitalInput(9);
    private DigitalInput armLimitDown = new DigitalInput(8);

    public Arm (XboxController xboxController, Victor armMotor){
        
        
        xbox = xboxController;
        motor = armMotor;


    }

    public void rotate() {

        if (xbox.getY(Hand.kLeft) > .2) {

            motor.setSpeed(-(xbox.getY(Hand.kLeft)));
        
        }
        else if (xbox.getY(Hand.kLeft) < -.2) {

            motor.setSpeed(-(xbox.getY(Hand.kLeft)));

        }
        else {

            motor.setSpeed(0);

        }

    }

    /*Top Limit True(armLimitUP.get()) = not clicked 
    * Bottom Limit True(armLimitDown.get()) = clicked
    * 
    */
    public void limitedRotation(){

        if (armLimitUp.get() && !armLimitDown.get()){

            rotate();

        }
        else if (!armLimitUp.get() && xbox.getY(Hand.kLeft) > .2){

            motor.setSpeed(-xbox.getY(Hand.kLeft));

        }
        else if (armLimitDown.get() && xbox.getY(Hand.kLeft) < -.2){

            motor.setSpeed(-xbox.getY(Hand.kLeft));

        }
        else {

            motor.setSpeed(0);

        }

    }

}