// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.ShootCommands.RampAndShoot;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RightAmpSide extends SequentialCommandGroup {
  /** Creates a new RightAmpSide. */
  public RightAmpSide() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RampAndShoot(), 
      new TimedTeleopDrive(
        RobotContainer.swerveSubsystem, () -> -0.7, () -> 0, () -> 0, 
        () -> true, 1000),
      new TimedTeleopDrive(
        RobotContainer.swerveSubsystem, () -> -0.5, () -> -0.5, () -> 0, 
        () -> true, 1000)
      );
  }
}
