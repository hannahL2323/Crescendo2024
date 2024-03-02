// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.FlopperArm;
import frc.robot.subsystems.FlopperWrist;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.AbsoluteDrive;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TimedClimb;
import frc.robot.commands.FlopperCommands.FlopperArmCommand;
// import frc.robot.commands.FlopperCommands.FlopperFlip;
import frc.robot.commands.FlopperCommands.FlopperReady;
import frc.robot.commands.FlopperCommands.FlopperZero;
// import frc.robot.commands.FlopperCommands.FlopperShoot;
import frc.robot.commands.FlopperCommands.FlopperWristCommand;
import frc.robot.commands.IntakeCommands.IndexerCommand;
import frc.robot.commands.IntakeCommands.IndexerUp;
import frc.robot.commands.IntakeCommands.IntakeBasic;
import frc.robot.commands.IntakeCommands.IntakeFinal;
import frc.robot.commands.IntakeCommands.IntakeInCommand;
import frc.robot.commands.IntakeCommands.TimedIndexer;
import frc.robot.commands.LEDCommands.RainbowCommand;
import frc.robot.commands.ShootCommands.AmpShootBasic;
import frc.robot.commands.ShootCommands.AmpShootFinal;
import frc.robot.commands.ShootCommands.ShooterCommand;
import frc.robot.commands.ShootCommands.SpeakerShoot;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IntakeSubsystem;



/** Add your docs here. */
public class RobotContainer {

    public static SwerveSubsystem swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                            "swerve"));

    public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static IndexerSubsystem indexerSubsystem = new IndexerSubsystem();

    public static FlopperArm flopperArm = new FlopperArm();
    public static FlopperWrist flopperWrist = new FlopperWrist();

    public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();

    public static LEDSubsystem ledSubsystem = new LEDSubsystem();

    // driver xbox
    XboxController driverController = new XboxController(0);

    JoystickButton driverA = new JoystickButton(driverController, 1);
    JoystickButton driverB = new JoystickButton(driverController, 2);
    JoystickButton driverX = new JoystickButton(driverController, 3);
    JoystickButton driverY = new JoystickButton(driverController, 4);
    JoystickButton driverLeftBumper = new JoystickButton(driverController, 5);
    JoystickButton driverRightBumper = new JoystickButton(driverController, 6);

    // operator xbox
    XboxController operatorController = new XboxController(1);

    JoystickButton operatorA = new JoystickButton(operatorController, 1);
    JoystickButton operatorB = new JoystickButton(operatorController, 2);
    JoystickButton operatorX = new JoystickButton(operatorController, 3);
    JoystickButton operatorY = new JoystickButton(operatorController, 4);
    JoystickButton operatorLeftBumper = new JoystickButton(operatorController, 5);
    JoystickButton operatorRightBumper = new JoystickButton(operatorController, 6);


    public RobotContainer() {
        configureBindings();

        // Command absoluteDrive = swerveSubsystem.driveCommand(
        //     () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
        //     () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
        //     () -> driverController.getRightX() * 0.5);

        // Command fieldOrientedDrive = swerveSubsystem.driveCommand(
        //     () -> MathUtil.applyDeadband(driverController.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
        //     () -> MathUtil.applyDeadband(driverController.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
        //     () -> driverController.getRightX() * 0.5);

        TeleopDrive teleopDrive = new TeleopDrive(
            swerveSubsystem,
            () -> MathUtil.applyDeadband(driverController.getLeftY() * 0.7, OperatorConstants.LEFT_Y_DEADBAND),
            () -> MathUtil.applyDeadband(driverController.getLeftX() * 0.7, OperatorConstants.LEFT_X_DEADBAND),
            () -> driverController.getRightX() * 0.7, () -> true);

        swerveSubsystem.setDefaultCommand(teleopDrive);
        
    }

    private void configureBindings() {

        // operatorA.whileTrue(new FlopperArmCommand(0.1));
        // operatorB.whileTrue(new FlopperArmCommand(-0.1));

        // operatorX.whileTrue(new FlopperWristCommand(0.1));
        // operatorY.whileTrue(new FlopperWristCommand(-0.1));

        // operatorA.onTrue(new FlopperReady());
        // operatorLeftBumper.onTrue(new FlopperShoot());
        
        // operatorLeftBumper.onTrue(new FlopperWristCommand(0.1, 45));
        // operatorRightBumper.onTrue(new FlopperWristCommand(-0.1, 0));


        operatorA.whileTrue(new IntakeFinal());
        operatorB.onTrue(new SpeakerShoot());
        operatorRightBumper.onTrue(new FlopperZero());
        operatorLeftBumper.onTrue(new AmpShootFinal());
        operatorX.onTrue(new TimedClimb(0.5, 1000));
        operatorY.onTrue(new TimedClimb(-0.5, 1000));


        // operatorA.onTrue(new TimedIndexer(0.3, 4000));
        // operatorB.whileTrue(new LauncherCommand(0.2));

        


        // // intake
        // operatorB.whileTrue(
        //     new IntakeInCommand(0.6));


        // // indexer
        // operatorX.whileTrue(
        //     new IndexerUp(0.3));
        
        // operatorY.whileTrue(
        //     new LauncherCommand(0.1));

        // operatorY.whileTrue(
        //     new IntakeAll());


        // operatorLeftBumper.whileTrue(
        //     new FlopperArmCommand(0.9));

        

        // // launcher
        // operatorA.whileTrue(
        //     new LauncherCommand(0.1));
        

        // // indexer
        // operatorX.whileTrue(
        //     new IndexerCommand(IndexerConstants.INDEXER_FORWARD_SPEED));

        // operatorY.whileTrue(
        //     new IndexerCommand(IndexerConstants.INDEXER_REVERSE_SPEED));

    }
    
}
