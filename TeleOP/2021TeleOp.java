package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "_2021TeleOp (Blocks to Java)")
public class _2021TeleOp extends LinearOpMode {

  private DcMotor leftFRONT;
  private DcMotor leftBACK;
  private DcMotor rightFRONT;
  private DcMotor rightBACK;
  private DcMotor Arm;
  private CRServo LEFTservo;
  private CRServo RIGHTservo;
  private DcMotor leftCARASOUL;
  private DcMotor rightCARASOUL;

  /**
   * Describe this function...
   */
  private void Set_Direction_Normal() {
    leftFRONT.setDirection(DcMotorSimple.Direction.REVERSE);
    leftBACK.setDirection(DcMotorSimple.Direction.REVERSE);
    rightFRONT.setDirection(DcMotorSimple.Direction.FORWARD);
    rightBACK.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    leftFRONT = hardwareMap.get(DcMotor.class, "leftFRONT");
    leftBACK = hardwareMap.get(DcMotor.class, "leftBACK");
    rightFRONT = hardwareMap.get(DcMotor.class, "rightFRONT");
    rightBACK = hardwareMap.get(DcMotor.class, "rightBACK");
    Arm = hardwareMap.get(DcMotor.class, "Arm");
    LEFTservo = hardwareMap.get(CRServo.class, "LEFTservo");
    RIGHTservo = hardwareMap.get(CRServo.class, "RIGHTservo");
    leftCARASOUL = hardwareMap.get(DcMotor.class, "leftCARASOUL");
    rightCARASOUL = hardwareMap.get(DcMotor.class, "rightCARASOUL");

    // Reverse one of the drive motors.
    Arm.setDirection(DcMotorSimple.Direction.REVERSE);
    LEFTservo.setDirection(DcMotorSimple.Direction.REVERSE);
    RIGHTservo.setDirection(DcMotorSimple.Direction.FORWARD);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        Set_Direction_Normal();
        // Put loop blocks here.
        Move_lol();
        Arm.setPower(-(gamepad2.left_bumper / 2));
        Arm.setPower(gamepad2.right_bumper / 2);
        LEFTservo.setPower(gamepad2.left_stick_y / 2);
        RIGHTservo.setPower(gamepad2.right_stick_y / 2);
        if (gamepad2.a) {
          leftCARASOUL.setPower(0);
          rightCARASOUL.setPower(0);
        }
        if (gamepad2.dpad_up) {
          leftCARASOUL.setDirection(DcMotorSimple.Direction.REVERSE);
          rightCARASOUL.setDirection(DcMotorSimple.Direction.REVERSE);
          rightCARASOUL.setPower(0.6);
          leftCARASOUL.setPower(0.6);
        }
        if (gamepad2.dpad_down) {
          leftCARASOUL.setDirection(DcMotorSimple.Direction.FORWARD);
          rightCARASOUL.setDirection(DcMotorSimple.Direction.FORWARD);
          leftCARASOUL.setPower(0.6);
          rightCARASOUL.setPower(0.6);
        }
        if (gamepad1.dpad_right) {
          Shift_Right();
        }
        if (gamepad1.dpad_left) {
          Shift_Left();
        }
        if (gamepad1.dpad_down) {
          Turbo_Boost_Backward();
        }
        if (gamepad1.dpad_up) {
          Turbo_Boost_Forward();
        }
        telemetry.addData("Left Pow", leftBACK.getPower());
        telemetry.addData("Right Pow", rightBACK.getPower());
        telemetry.update();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Shift_Right() {
    Set_Direction_DPAD();
    Move_Right_Power();
    sleep(500);
  }

  /**
   * Describe this function...
   */
  private void Move_lol() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(-(gamepad1.left_stick_y / 2));
    rightBACK.setPower(-(gamepad1.right_stick_y / 2));
    rightFRONT.setPower(-(gamepad1.right_stick_y / 2));
    leftFRONT.setPower(-(gamepad1.left_stick_y / 2));
  }

  /**
   * Describe this function...
   */
  private void Shift_Left() {
    Set_Direction_DPAD();
    Move_Left_Power();
    sleep(500);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Right_Power() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(-1);
    leftFRONT.setPower(1);
    rightBACK.setPower(1);
    rightFRONT.setPower(-1);
  }

  /**
   * Describe this function...
   */
  private void Set_Direction_DPAD() {
    leftFRONT.setDirection(DcMotorSimple.Direction.REVERSE);
    leftBACK.setDirection(DcMotorSimple.Direction.REVERSE);
    rightFRONT.setDirection(DcMotorSimple.Direction.FORWARD);
    rightBACK.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Left_Power() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(1);
    leftFRONT.setPower(-1);
    rightBACK.setPower(-1);
    rightFRONT.setPower(1);
  }

  /**
   * Describe this function...
   */
  private void Turbo_Boost_Forward() {
    Set_Direction_DPAD();
    Move_Forward_Power();
    sleep(1200);
  }

  /**
   * Describe this function...
   */
  private void Grab_Function(
      // TODO: Enter the type for argument named Position2
      UNKNOWN_TYPE Position2,
      long time2) {
    Grab_Position(Position2);
    sleep(time2);
  }

  /**
   * Describe this function...
   */
  private void Turbo_Boost_Backward() {
    Set_Direction_DPAD();
    Move_Backward_Power();
    sleep(500);
  }

  /**
   * Describe this function...
   */
  private void Grab_Position(
      // TODO: Enter the type for argument named Position2
      UNKNOWN_TYPE Position2) {
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Forward_Power() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(1);
    leftFRONT.setPower(1);
    rightBACK.setPower(1);
    rightFRONT.setPower(1);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Backward_Power() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    rightBACK.setPower(-1);
    leftBACK.setPower(-1);
    rightFRONT.setPower(-1);
    leftFRONT.setPower(-1);
  }
}
