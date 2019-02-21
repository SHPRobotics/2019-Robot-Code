package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Climber {

    private XboxController xbox;
    private DoubleSolenoid frontPis; 
    private DoubleSolenoid backPis;
    private DoubleSolenoid stablePis;
    private boolean frontExtended = false;
    private boolean backExtended = false;
    private boolean stableExtend = false;

    public Climber (XboxController xboxController, DoubleSolenoid frontClimbPiston, DoubleSolenoid backClimbPiston, DoubleSolenoid stableClimbPiston) {

        xbox = xboxController;
        frontPis = frontClimbPiston;
        backPis = backClimbPiston;
        stablePis = stableClimbPiston;

    }

    public void climb() {

        if(xbox.getStartButtonPressed()) {

            if(!frontExtended) {

                frontPis.set(DoubleSolenoid.Value.kForward);
                frontExtended = true;

            }

            else {

                frontPis.set(DoubleSolenoid.Value.kReverse);
                frontExtended = false;

            }

        }

        if(xbox.getBackButtonPressed()) {

            if(!backExtended) {

                backPis.set(DoubleSolenoid.Value.kForward);
                backExtended = true;

            }

            else {

                backPis.set(DoubleSolenoid.Value.kReverse);
                backExtended = false;

            }

        }

        if (xbox.getBumperPressed(Hand.kLeft)){

            if(!stableExtend) {

                stablePis.set(DoubleSolenoid.Value.kForward);
                stableExtend = true;

            }

            else {

                stablePis.set(DoubleSolenoid.Value.kReverse);
                stableExtend = false;

            }

        }

    }

    public void climbTest() {

        if(xbox.getBackButton()) {

            stablePis.set(DoubleSolenoid.Value.kForward);

        }

        else {

            stablePis.set(DoubleSolenoid.Value.kReverse);

        }

    }
    
}