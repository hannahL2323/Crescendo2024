// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/** Add your docs here. */
public class Constants {

    public static class RobotConstants {
        public static final double ROBOT_MASS = 100 * 0.453592; // 32lbs * kg per pound
        public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
        public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
    }

    public static class IntakeConstants {
        // FIXME: ids
        public static final int INTAKE_MOTOR = 7;

        public static final double INTAKE_SPEED = 0;

    }

    public static class IndexerConstants {
        // FIXME: ids
        public static final int INDEXER_MOTOR_RIGHT = 9;
        public static final int INDEXER_MOTOR_LEFT = 4;

        public static final int PROXIMITY_PORT = 3;


        public static final double INDEXER_FORWARD_SPEED = 0.2;
        public static final double INDEXER_REVERSE_SPEED = -0.1;

    }

    public static class ShooterConstants {
        public static final int SHOOTER_MOTOR_LEFT = 2;
        public static final int SHOOTER_MOTOR_RIGHT = 6;

        // FIXME: velocity
        public static final double LAUNCHER_SPEED_HIGH = 0.5;
        public static final double LAUNCHER_SPEED_LOW = 0;

    }

    public static class FlopperConstants {
        public static final int FLOPPER_ARM = 17;
        public static final int FLOPPER_WRIST = 18;
    }

    public static class ClimberConstants {
        public static final int CLIMBER_LEFT = 1;
        public static final int CLIMBER_RIGHT = 8;

    }

    public static class OperatorConstants {
        // Joystick Deadband
        public static final double LEFT_X_DEADBAND = 0.1;
        public static final double LEFT_Y_DEADBAND = 0.1;
        public static final double RIGHT_X_DEADBAND = 0.1;

    }

    public static class LEDConstants {
        public static final int LED_PORT = 3;

        public static final int WHITE = 0xFFFFFF;
        public static final int RED = 0xFF0000;
        public static final int YELLOW = 0xFFFF00;
        public static final int GREEN = 0x00FF00;
        public static final int PURPLE = 0x800080;
        public static final int BLUE = 0x0000FF;
        public static final int LIME = 0x39FF14;
    }

    public static class OtherConstants {
    }
}
