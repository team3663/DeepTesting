/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.command_groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.C_EndEffectorAngle;
import frc.robot.commands.C_Flip;
import frc.robot.commands.C_FrontClimber;
import frc.robot.commands.C_SetEndEffectorIntakeSpeed;
import frc.robot.commands.C_SetFrontClimberIntake;
import frc.robot.commands.C_WaitForBall;
import frc.robot.commands.test_commands.C_ElevatorToInch;

public class CG_BallIntake extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CG_BallIntake() {
    addSequential(new C_FrontClimber(90));
    addSequential(new C_Flip(true));
    addParallel(new C_ElevatorToInch(0)); 
    addSequential(new C_SetEndEffectorIntakeSpeed(-.3));  
    addSequential(new C_SetFrontClimberIntake(-1));
    addSequential(new C_WaitForBall());
    addSequential(new C_SetFrontClimberIntake(0));
    addSequential(new C_SetEndEffectorIntakeSpeed(0));
    addSequential(new C_EndEffectorAngle(0));
    addSequential(new C_FrontClimber(0));
  }
}
