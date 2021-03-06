/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class C_GoToRelativeLevel extends Command {
  private double adjustment;

  /**
   * move to inchaes relative of selected level
   * 
   * @param adjustment inches to move from selected level
   */
  public C_GoToRelativeLevel(double adjustment) {
    requires(Robot.getElevator());
    this.adjustment = adjustment;
  }

  @Override
  protected void execute() {
    Robot.getElevator().goToSelectedWithAdjustment(adjustment);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.getElevator().atTarget(Robot.getElevator().getAverageInch() + adjustment);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
