package org.xbot.ftc.operatingcode.teleop.operator_2;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.xbot.ftc.operatingcode.teleop.XbotOperatorSubHandler;
import org.xbot.ftc.robotcore.subsystems.cube.CubeElevator;

public class TeleOpElevator extends XbotOperatorSubHandler {

    private CubeElevator cubeElevator;

    @Override
    public void start(HardwareMap hardwareMap, Telemetry telemetry) {
        super.start(hardwareMap, telemetry);
        cubeElevator = (CubeElevator) robotSystemsManager.getSubsystem(CubeElevator.CLASS_NAME);
    }

    @Override
    public void handle(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad2.left_bumper || gamepad1.left_bumper) {
            cubeElevator.setPower(1);
        } else if (gamepad2.left_trigger > 0.1  || gamepad2.left_trigger > 0.1) {
            cubeElevator.setPower(-1);
        } else {
            cubeElevator.setPower(0);
        }
    }

    @Override
    public void stop() {
        cubeElevator.stop();
    }

    @Override
    public void updateTelemetry() {

    }
}
