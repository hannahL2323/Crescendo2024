// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class ClimberSubsystem extends SubsystemBase {
  Spark climberLeft;
  Spark climberRight;

  public long upTime = 0;

  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {
    climberLeft = new Spark(ClimberConstants.CLIMBER_LEFT);
    climberRight = new Spark(ClimberConstants.CLIMBER_RIGHT);
  }

  
  public void runClimberLeft(double speed) {
    climberLeft.set(speed);
  }

  public void runClimberRight(double speed) {
    climberRight.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
