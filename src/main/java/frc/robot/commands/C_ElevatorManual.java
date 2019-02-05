/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class C_ElevatorManual extends Command {
  private final double DEAD_BAND = 0.05;
  public C_ElevatorManual() {
    requires(Robot.getElevator());
  }

  private double ignoreDeadBand(double input){
    if(Math.abs(input) < DEAD_BAND){
      return 0;
    }
    return input;
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = Robot.getOI().getSecondaryController().getRightYValue();
    if(rightBumperIsPressed()){
      Robot.getElevator().setElevatorSpeed(ignoreDeadBand(speed));
    }else{
      Robot.getElevator().setElevatorSpeed(0);
    }
  }

  private boolean rightBumperIsPressed(){
    return Robot.getOI().getSecondaryController().getRightBumperButton().get();
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.getElevator().setElevatorSpeed(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
