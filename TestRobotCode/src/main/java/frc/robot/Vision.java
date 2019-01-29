package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {

	public PixyI2C Pixy;
	Port port = Port.kOnboard;
	String print;
	public PixyPacket[] packet1 = new PixyPacket[7];

	public Vision() {
		Pixy = new PixyI2C(new I2C(port, 0x54), packet1, new PixyException(print), new PixyPacket());
	}

	public void initDefaultCommand() {
		// TODO: Should we add a PixyIdle command? What should it do? Nothing?
		// Might be useful to have it call some function to get target and print
		// to dashboard? Eh.. if robot isn't aimed at the target we get nothing.
	}

	public void testPixy() {
		for (int i = 0; i < packet1.length; i++)
			packet1[i] = null;
		SmartDashboard.putString("Pixy hello", "working");
		for (int i = 1; i < 8; i++) {
			try {
				packet1[i - 1] = Pixy.readPacket(i);
			} catch (PixyException e) {
				SmartDashboard.putString("Pixy Error: " + i, "exception");
			}
			if (packet1[i - 1] == null) {
				SmartDashboard.putString("Pixy Error: " + i, "True");
				continue;
			}
			SmartDashboard.putNumber("Pixy X Value: " + i, packet1[i - 1].X);
			SmartDashboard.putNumber("Pixy Y Value: " + i, packet1[i - 1].Y);
			SmartDashboard.putNumber("Pixy Width Value: " + i, packet1[i - 1].Width);
			SmartDashboard.putNumber("Pixy Height Value: " + i, packet1[i - 1].Height);
			SmartDashboard.putString("Pixy Error: " + i, "False");
		}
	}
}