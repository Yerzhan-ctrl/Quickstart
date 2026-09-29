package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.revhub.drivetrains.CoaxialPod;
import com.pedropathing.revhub.drivetrains.Swerve;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;

import org.firstinspires.ftc.teamcode.pedro.procedures.Tests;

public class Tuning {
    // Tuners go here
    @Tuner
    public static Procedure tests() {
        return new Tests(
                hardwareMap -> new Swerve(hardwareMap, Constants.driveConfig,
                        new CoaxialPod(hardwareMap, Constants.leftBack),
                        new CoaxialPod(hardwareMap, Constants.leftFront),
                        new CoaxialPod(hardwareMap, Constants.rightBack),
                        new CoaxialPod(hardwareMap, Constants.rightFront)
                ),
                hardwareMap -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig),
                () -> new Foresight(Constants.foresightConfig)
        );
    }
}
