/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.C_EFToAngle;
import frc.robot.commands.C_Flip;
import frc.robot.commands.C_FrontClimber;
import frc.robot.commands.C_SetEFIntakeSpeed;
import frc.robot.commands.C_SetFrontClimberIntake;
import frc.robot.commands.test_commands.C_ElevatorToInch;

public class CG_FeederBallIntake extends CommandGroup {
  /**
   * aligns to intake from feeder station
   */
  public CG_FeederBallIntake() {
    addSequential(new C_Flip(true));
    addSequential(new C_ElevatorToInch(4));
    addSequential(new C_FrontClimber(60));
    addSequential(new C_EFToAngle(45));
    addSequential(new C_SetFrontClimberIntake(-1));
    addSequential(new C_SetEFIntakeSpeed(-.3));
  }
}
