/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {

    
    //Pnumatics
    Compressor airTank = new Compressor(0);
    DoubleSolenoid frontPiston = new DoubleSolenoid(0, 1);
    DoubleSolenoid stablePiston = new DoubleSolenoid(2, 3);
    DoubleSolenoid backPiston = new DoubleSolenoid(4, 5);

    //Motors
    Victor hmotor = new Victor(7);
    Victor bmotor = new Victor(8);
    Victor amotor = new Victor(9);

    WPI_TalonSRX masterTalonLeft = new WPI_TalonSRX(1);
    WPI_TalonSRX slaveTalonLeft = new WPI_TalonSRX(2);
    WPI_TalonSRX masterTalonRight = new WPI_TalonSRX(4);
    WPI_TalonSRX slaveTalonRight = new WPI_TalonSRX(3);
  
    //Joystics
    Joystick leftJoy = new Joystick(0);
    Joystick rightJoy = new Joystick(1);
    XboxController xbox = new XboxController(2);
    
    //Classes 
    Drive talonDrive = new Drive(leftJoy, rightJoy, masterTalonLeft, masterTalonRight);
    Hatch hatch = new Hatch(xbox, hmotor);
    Ball ball = new Ball(xbox, bmotor);
    Arm arm = new Arm(xbox, amotor);
    Climber climber = new Climber(xbox, frontPiston, backPiston, stablePiston);

    //Differential Drive
    SpeedControllerGroup talonLeftSide = new SpeedControllerGroup(slaveTalonLeft, masterTalonLeft);
    SpeedControllerGroup talonRightSide = new SpeedControllerGroup(masterTalonRight, slaveTalonRight);
    DifferentialDrive diffTalonDrive = new DifferentialDrive(talonLeftSide, talonRightSide);

    //Vision
    Limelight vision = new Limelight(diffTalonDrive, rightJoy);
    
  @Override
  public void robotInit() {

    airTank.start();

    masterTalonLeft.configFactoryDefault();
    slaveTalonLeft.configFactoryDefault();
    masterTalonRight.configFactoryDefault();
    slaveTalonRight.configFactoryDefault();

    masterTalonLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    masterTalonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

    slaveTalonLeft.follow(masterTalonLeft);
    slaveTalonRight.follow(masterTalonRight);

  }


  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    talonDrive.linearTalonDrive();
    hatch.limitedRotation();
    ball.rotate();
    arm.limitedRotation();
    climber.climb();
    vision.checkTarget();
    //vision.aim();
    
    //talonDrive.leftXRotations(1.0);

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
