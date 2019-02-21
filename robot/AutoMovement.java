package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class AutoMovement {

    private WPI_TalonSRX mtl;
    private WPI_TalonSRX mtr;
    private Joystick ljoy;
    private Joystick rjoy;
    XboxController xbox;

    public AutoMovement(XboxController xboxController, Joystick lefJoystick, Joystick righJoystick, WPI_TalonSRX masterTalonLeft, WPI_TalonSRX masterTalonRight) {


    }
    
    public void emergencyStop() {

        if (ljoy.getRawButton(8) || (xbox.getBumper(Hand.kLeft) && xbox.getBumper(Hand.kRight))) {

            mtl.stopMotor();
            mtr.stopMotor();

        }

    }

    public void autoStraight() {

        if (ljoy.getRawButton(12)) {

            //insert code to set talon to zero
            //insert code to move both mtl and mtr at the same time to the same position using position control mode

        }

        else if (ljoy.getRawButton(11)) {

            //insert code to set talon to zero
            //insert code to move both mtl and mtr at the same time to the same position using position control mode

        }

    }


}