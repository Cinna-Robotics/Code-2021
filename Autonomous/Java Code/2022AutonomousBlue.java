package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "_2022AutonomousBlue (Blocks to Java)")
public class _2022AutonomousBlue extends LinearOpMode {

  private DcMotor leftFRONT;
  private DcMotor leftBACK;
  private DcMotor rightFRONT;
  private DcMotor rightBACK;
  private DcMotor leftCARASOUL;

  /**
   * Sets the direction of the motors
   */
  private void Set_Direction_DPAD() {
    leftFRONT.setDirection(DcMotorSimple.Direction.REVERSE);
    leftBACK.setDirection(DcMotorSimple.Direction.REVERSE);
    rightFRONT.setDirection(DcMotorSimple.Direction.FORWARD);
    rightBACK.setDirection(DcMotorSimple.Direction.FORWARD);
  }

  /**
   * Mess around with the 500 millisecond duration to get robot over to carousal
   */
  private void Shift_Right(double Power, long Time) {
    Set_Direction_DPAD();
    Move_Right_Power(Power);
    sleep(Time);
  }

  /**
   * Describe this function...
   */
  private void Shift_Left(double Power, int Time) {
    Set_Direction_DPAD();
    Move_Left_Power(Power);
    sleep(Time);
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
    leftCARASOUL = hardwareMap.get(DcMotor.class, "leftCARASOUL");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Goal:
        // 1) Shift right to carousel
        // 2) Turn on motors for carousel
        // 3) Drive forward into parking zone
        // Put loop blocks here.
        Shift_Left(0.4, 2000);
        Shift_Left(0, 2000);
        leftCARASOUL.setDirection(DcMotorSimple.Direction.FORWARD);
        leftCARASOUL.setPower(0.6);
        Shift_Left(0, 5000);
        leftCARASOUL.setPower(0);
        Move_Forward(0.4, 1000);
        Shift_Left(0, 3000);
        Shift_Left(0.4, 200);
        Shift_Left(0, 10000000);
      }
    }
  }

  /**
   * Adjusts the power of shifting right
   */
  private void Move_Right_Power(double Power) {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(-Power);
    leftFRONT.setPower(Power);
    rightBACK.setPower(Power);
    rightFRONT.setPower(-Power);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Left_Power(double Power) {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(Power);
    leftFRONT.setPower(-Power);
    rightBACK.setPower(-Power);
    rightFRONT.setPower(Power);
  }

  /**
   * Describe this function...
   */
  private void Move_Forward(double Power, int Time) {
    Set_Direction_DPAD();
    Move_Forward_Power(Power);
    sleep(Time);
  }

  /**
   * Describe this function...
   */
  private void Move_Backward(double Power, long Sleep) {
    Set_Direction_DPAD();
    Move_Backward_Power(Power);
    sleep(Sleep);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Forward_Power(double Power) {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    leftBACK.setPower(Power);
    leftFRONT.setPower(Power);
    rightBACK.setPower(Power);
    rightFRONT.setPower(Power);
  }

  /**
   * Describe this function...http://192.168.43.1:8080/?page=FtcBlocks.html?project=Drive&pop=true
   */
  private void Move_Backward_Power(double Power) {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    rightBACK.setPower(-Power);
    leftBACK.setPower(-Power);
    rightFRONT.setPower(-Power);
    leftFRONT.setPower(-Power);
  }
}