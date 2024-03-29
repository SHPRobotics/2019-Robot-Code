package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Limelight {

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    double v = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double x = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double y = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    double a = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    
    // These numbers must be tuned for your Robot!  Be careful!
    private final double STEER_K = 0.03;                    // how hard to turn toward the target
    private final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
    private final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
    private final double MAX_DRIVE = 0.70;                   // Simple speed limit so we don't drive too fast
                                                                                                                                  
    // Eh
    private boolean hasTarget = false;
    private double autoDriving = 0.0;
    private double autoSteering = 0.0;

    // Whatever
    private Joystick rjoy;

    // Motors ig
    DifferentialDrive dTrain;
    TalonSRX rightTalon;
    TalonSRX leftTalon;

    public Limelight(DifferentialDrive driveTrain, Joystick rightJoystick) {

      dTrain = driveTrain;
      rjoy = rightJoystick;

    }

    public void checkTarget() {

      if (hasTarget) {

        System.out.println("Has target");

      }

      else {

        System.out.println("No Target");

      }

    }

    public void aim() {

        if (v == 1) {

          hasTarget = true;

        }

        else {

          hasTarget = false;
          autoDriving = 0.0;
          autoSteering = 0.0;

        }
        
        // Start with proportional steering
        double steerSpeed = x * STEER_K;
        autoSteering = steerSpeed;

        // try to drive forward until the target area reaches our desired area
        double driveSpeed = (DESIRED_TARGET_AREA - a) * DRIVE_K;

        // don't let the robot drive too fast into the goal
        if (driveSpeed > MAX_DRIVE) {
          driveSpeed = MAX_DRIVE;
        }
        autoDriving = driveSpeed;

        boolean auto = rjoy.getRawButton(2);

        if (auto) {
          if (hasTarget) {
            dTrain.arcadeDrive(autoDriving, autoSteering);
          }
          else {
            dTrain.arcadeDrive(0.0,0.0);
          }
        }
        else {
          
          rightTalon.set(ControlMode.PercentOutput, 0);
          leftTalon.set(ControlMode.PercentOutput, 0);


        }
    }
}