package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.CoaxialPod;
import com.pedropathing.revhub.drivetrains.CoaxialPodConfig;
import com.pedropathing.revhub.drivetrains.Swerve;
import com.pedropathing.revhub.drivetrains.SwerveConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(c -> {
    });

    public static CoaxialPodConfig leftFront = new CoaxialPodConfig(
            c -> {
                c.name.set("left_front");
                c.motorName.set("left_front");
                c.servoName.set("lfTurn");
                c.servoEncoderName.set("lfTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.0086)
                        .plus(Controller.proportionalFeedforward(0.0130)));

                c.driveDirection.set(DcMotorSimple.Direction.REVERSE);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);

                c.angleOffsetRad.set(Math.toRadians(0));
                c.podOffset.set(Vector2D.cartesian(-6, 6));
            }
    );

    public static CoaxialPodConfig rightFront = new CoaxialPodConfig(
            c -> {
                c.name.set("right_front");
                c.motorName.set("right_front");
                c.servoName.set("rfTurn");
                c.servoEncoderName.set("rfTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.0086)
                        .plus(Controller.proportionalFeedforward(0.0130)));

                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);

                c.angleOffsetRad.set(Math.toRadians(0));
                c.podOffset.set(Vector2D.cartesian(6, 6));
            }
    );

    public static CoaxialPodConfig leftBack = new CoaxialPodConfig(
            c -> {
                c.name.set("left_back");
                c.motorName.set("left_back");
                c.servoName.set("lbTurn");
                c.servoEncoderName.set("lbTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.0086)
                        .plus(Controller.proportionalFeedforward(0.0190)));

                c.driveDirection.set(DcMotorSimple.Direction.REVERSE);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);

                c.angleOffsetRad.set(Math.toRadians(0));
                c.podOffset.set(Vector2D.cartesian(-6, -6));
            }
    );

    public static CoaxialPodConfig rightBack = new CoaxialPodConfig(
            c -> {
                c.name.set("right_back");
                c.motorName.set("right_back");
                c.servoName.set("rbTurn");
                c.servoEncoderName.set("rbTurnEncoder");
                c.turnController.set(Controller.pid(0.3, 0, 0.0086)
                        .plus(Controller.proportionalFeedforward(0.0190)));
                c.driveDirection.set(DcMotorSimple.Direction.FORWARD);
                c.servoDirection.set(DcMotorSimple.Direction.FORWARD);

                c.angleOffsetRad.set(Math.toRadians(0));
                c.podOffset.set(Vector2D.cartesian(6, -6));
            }
    );

    public static SwerveConfig driveConfig = new SwerveConfig(
            c -> {
                c.zeroPowerBehavior.set(SwerveConfig.ZeroPowerBehavior.X_LOCK);
                c.manualBrakeMode.set(true);
                c.voltageCompensation.set(false);
            }
    );

    public static Follower create(HardwareMap h) {
        CoaxialPod leftFrontPod = new CoaxialPod(h, leftFront);
        CoaxialPod rightFrontPod = new CoaxialPod(h, rightFront);
        CoaxialPod leftBackPod = new CoaxialPod(h, leftBack);
        CoaxialPod rightBackPod = new CoaxialPod(h, rightBack);
        return new Follower(new PinpointLocalizer(h, localizerConfig), new Swerve(h, driveConfig,
                leftBackPod, leftFrontPod, rightBackPod, rightFrontPod), new Foresight(foresightConfig));
    }
}
