/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class C_CrabDrive extends Command {
  private double multiplier;
  /**
   * starts trigger controll of fclimb intake for climbing
   * 
   */
  public C_CrabDrive(double multiplier) {
    this.multiplier = multiplier;
    requires(Robot.getBall());
  }

  @Override
  protected void execute() {
    Robot.getBall().setClimberIntakeSpeed(-Robot.getOI().getSecondaryController().getRightTriggerValue() * multiplier);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}
