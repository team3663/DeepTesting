/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.command_groups.CG_BallIntake;
import frc.robot.commands.command_groups.CG_BallMode;

public class C_IntakeSelect extends Command {
  public C_IntakeSelect() {
    requires(Robot.getEndEffectorAngle());
  }

  @Override
  protected void execute() {
    if(!Robot.getEndEffectorAngle().isHatchMode()) {
      new CG_BallIntake().start();
    }
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

}
