package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.SS_HolonomicDrivetrain;

public class C_HolonomicDrive extends Command {
	private final SS_HolonomicDrivetrain mDrivetrain;

	public C_HolonomicDrive() {
		mDrivetrain = Robot.getDrivetrain();

		requires(mDrivetrain);
	}

	private double deadband(double input) {
		if (Math.abs(input) < 0.05) return 0;
		return input;
	}

	@Override
	protected void execute() {
		double forward = -Robot.getOI().getPrimaryController().getLeftYValue();
		double strafe = Robot.getOI().getPrimaryController().getLeftXValue();
		double rotation = Robot.getOI().getPrimaryController().getRightXValue();

		forward *= Math.abs(forward);
		strafe *= Math.abs(strafe);
		rotation *= Math.abs(rotation);

		forward = deadband(forward);
		strafe = deadband(strafe);
		rotation = deadband(rotation);

		SmartDashboard.putNumber("Forward", forward);
		SmartDashboard.putNumber("Strafe", strafe);
		SmartDashboard.putNumber("Rotation", rotation);

		mDrivetrain.holonomicDrive(forward, strafe, rotation);
	}

	@Override
	protected void end() {
		mDrivetrain.stopDriveMotors();
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
