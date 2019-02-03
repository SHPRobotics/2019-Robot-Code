package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

public class Limelight {

    private Joystick rjoy;

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    public Limelight(Joystick rightJoystick) {

        rjoy = rightJoystick;

    }

    public void getCoor() {
    //post to smart dashboard periodically
    SmartDashboard.putNumber("Limelight Value X: ", x);
    SmartDashboard.putNumber("Limelight Value Y: ", y);
    SmartDashboard.putNumber("Limelight Value Area: ", area);
    }
    
    public void aim() {

        final double KP = -0.1f;

        if (rjoy.getRawButton(2)) {

            double headingError = x;
            double steeringAdjust = KP * x;

            double leftCommand =+ steeringAdjust;
            double rightCommand =- steeringAdjust;

        }

    }

    public void getDistance() {



    }

}