package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Drive {

    //Private Variables for motors and joysticks 

    Joystick lj;
    Joystick rj;
    Spark ld; 
    Spark rd; 
    WPI_TalonSRX mtl;
    WPI_TalonSRX mtr;

    public Drive(Joystick leftJoystick, Joystick rightJoystick, Spark leftSpark, Spark rightSpark)  {

        lj = leftJoystick;
        rj = rightJoystick;
        ld = leftSpark;
        rd = rightSpark;

    }

    public Drive(Joystick leftJoystick, Joystick rightJoystick, WPI_TalonSRX masterTalonLeft, WPI_TalonSRX masterTalonRight) {

        lj = leftJoystick;
        rj = rightJoystick;
        mtl = masterTalonLeft;
        mtr = masterTalonRight;

    }
    
    public void linearSparkDrive() {
        
       if (lj.getY() > 0.1 || lj.getY() < -0.1) {

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
    
    public void linearTalonDrive() {

        if(lj.getY() > 0.1 || lj.getY() < -0.1) {

            mtl.set(ControlMode.PercentOutput, -lj.getY());

        }

        else {

            mtl.set(ControlMode.PercentOutput, 0);


        }

        if(rj.getY() > 0.1 || rj.getY() < -0.1) {

            mtr.set(ControlMode.PercentOutput, rj.getY());


        }

        else {

        
            mtr.set(ControlMode.PercentOutput, 0);

        }
    }

    public void linearEncoderDrive() {

        if(lj.getY() > 0.1 || lj.getY() < -0.1) {

            mtl.set(ControlMode.PercentOutput, -lj.getY());

        }

        else {

            mtl.set(ControlMode.PercentOutput, 0);


        }

        if(rj.getY() > 0.1 || rj.getY() < -0.1) {

            mtr.set(ControlMode.PercentOutput, rj.getY());


        }

        else {

            mtr.set(ControlMode.PercentOutput, 0);

        }

    }

    public void leftXRotations(Double x){

        if (lj.getRawButton(4)){

            mtl.set(ControlMode.Position, 4096*x);

        }

        else {

            linearTalonDrive();

        }

    }

    public void rightXRotations(Double x){

        if (lj.getRawButton(3)){

            mtr.set(ControlMode.Position, 4096*x);

        }

        else {

            linearTalonDrive();

        }

    }

}