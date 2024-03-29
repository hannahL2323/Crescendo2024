// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.LEDConstants;
import frc.robot.commands.LEDCommands.ColourCommand;
import frc.robot.commands.ShootCommands.TimedShooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeFinal extends SequentialCommandGroup {
  /** Creates a new IntakeFinal. */
  public IntakeFinal() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new IntakeBasic(), new IndexerShooterDown(), new ColourCommand(LEDConstants.PURPLE));
  }
}
