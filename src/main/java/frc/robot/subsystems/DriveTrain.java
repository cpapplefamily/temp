// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  Spark leftfront;
  Spark rightfront;
  Spark leftrear;
  Spark rightrear;
  SpeedControllerGroup leftmotors;
  SpeedControllerGroup rightmotors;
  DifferentialDrive drive;
  
  public DriveTrain() {
  leftfront = new Spark(Constants.leftfront);
  leftfront.setInverted(false);
  rightfront = new Spark(Constants.rightfront);
  rightfront.setInverted(false);
  leftrear = new Spark(Constants.leftrear);
  leftrear.setInverted(false);
  rightrear = new Spark(Constants.rightrear);
  rightrear.setInverted(false);

  leftmotors = new SpeedControllerGroup(leftfront, leftrear);
  rightmotors = new SpeedControllerGroup(rightfront, rightrear);
  drive = new DifferentialDrive(leftmotors, rightmotors);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drivewithJoysticks(double speed, double turn)
  {
  drive.arcadeDrive(speed, turn);
  }

 public void stop ()
 {
   drive.stopMotor();
 }
//Autonomous

public void driveforward(double speed)
{
  drive.tankDrive(speed, speed);
}

public void driveforward(double lspeed, double rspeed) {
  drive.tankDrive(lspeed, rspeed);
}



}