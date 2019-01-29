/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.XboxController;
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
    Compressor airTank = new Compressor();

    //Motors
    Spark leftDrive = new Spark(0);
    Spark rightDrive = new Spark(1);
    Victor hmotor = new Victor(2);

    //WPI_TalonSRX talon1 = new WPI_TalonSRX(1);
    //TalonSRX tal2 = new TalonSRX(2);
  
    //Joystics
    Joystick leftJoy = new Joystick(2);
    Joystick rightJoy = new Joystick(1);
    XboxController xbox = new XboxController(0);
    
    //Classes 
    Drive drive = new Drive(leftJoy, rightJoy, leftDrive, rightDrive);
    Hatch hatch = new Hatch(xbox, hmotor);

    //Vision
    Vision vision = new Vision();
  
  @Override
  public void robotInit() {

    airTank.start();

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

    drive.linearDrive();
    vision.testPixy();
    hatch.rotate();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
