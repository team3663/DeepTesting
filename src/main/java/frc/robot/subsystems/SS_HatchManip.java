/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class SS_HatchManip extends Subsystem {

  private CANSparkMax hatchMotor;

  private double hatchMotorSpeedMultiplier = 1;

  public SS_HatchManip() {
    hatchMotor = new CANSparkMax(RobotMap.HATCH_MOTOR, MotorType.kBrushless);
  }

  public void setHatchMotorSpeed(double speed) {
    hatchMotor.set(speed * hatchMotorSpeedMultiplier);
  }

  public void setHatchMotorSpeedMultiplier(double speedMultipler) {
    hatchMotorSpeedMultiplier = speedMultipler;
  }

  @Override
  public void initDefaultCommand() {
  }
}
