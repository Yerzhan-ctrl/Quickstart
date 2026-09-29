package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.CoaxialPodConfig;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.drivetrains.SwerveConfig;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static double dtLength = 12.0; // Distance from center to front/back pod in inches
    public static double dtWidth  = 12.0; // Distance from center to left/right pod in inches
    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("left_front");
        c.frontRightName.set("right_front");
        c.backLeftName.set("left_back");
        c.backRightName.set("right_back");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.manualBrakeMode.set(true);
    });
    public static SwerveConfig driveConfig = new SwerveConfig(
            c -> {
                c.zeroPowerBehavior.set(SwerveConfig.ZeroPowerBehavior.IGNORE_ANGLE_CHANGES);
                c.manualBrakeMode.set(true);
                c.voltageCompensation.set(false);
            }
    );

    public static CoaxialPodConfig rightBack = new CoaxialPodConfig(
            c -> {
                c.name.set("right_back");
                c.motorName.set("right_back");
                c.servoName.set("rbTurn");
                c.servoEncoderName.set("rbTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.005)
                        .plus(Controller.proportionalFeedforward(0)));
                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);
                c.analogMinVoltage.set(0.010);
                c.analogMaxVoltage.set(3.290);
                c.angleOffsetRad.set(0.0); //or 1.5708
                c.podOffset.set(Vector2D.cartesian(dtLength, dtWidth));
            }
    );

    public static CoaxialPodConfig leftFront = new CoaxialPodConfig(
            c -> {
                c.name.set("left_front");
                c.motorName.set("left_front");
                c.servoName.set("lfTurn");
                c.servoEncoderName.set("lfTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.005)
                        .plus(Controller.proportionalFeedforward(0)));
                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);
                c.analogMinVoltage.set(0.012);
                c.analogMaxVoltage.set(3.285);
                c.angleOffsetRad.set(0.0); //or 3.1415
                c.podOffset.set(Vector2D.cartesian(dtLength, -dtWidth));
            }
    );

    public static CoaxialPodConfig rightFront = new CoaxialPodConfig(
            c -> {
                c.name.set("right_front");
                c.motorName.set("right_front");
                c.servoName.set("rfTurn");
                c.servoEncoderName.set("rfTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.005)
                        .plus(Controller.proportionalFeedforward(0)));
                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);
                c.analogMinVoltage.set(0.010);
                c.analogMaxVoltage.set(3.290);
                c.angleOffsetRad.set(0.0); //or 0.7854
                c.podOffset.set(Vector2D.cartesian(-dtLength, dtWidth));
            }
    );

    public static CoaxialPodConfig leftBack = new CoaxialPodConfig(
            c -> {
                c.name.set("left_back");
                c.motorName.set("left_back");
                c.servoName.set("lbTurn");
                c.servoEncoderName.set("lbTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.0086)
                        .plus(Controller.proportionalFeedforward(0)));
                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);
                c.analogMinVoltage.set(0.010);
                c.analogMaxVoltage.set(3.290);
                c.angleOffsetRad.set(0.0); //or 2.3561
                c.podOffset.set(Vector2D.cartesian(-dtLength, -dtWidth));
            }
            //All analog max/min voltage setting values are temporary! I didn't check them on the voltage scale yet!
    );
}
