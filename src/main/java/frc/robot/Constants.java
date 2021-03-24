// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
 //PWM Numbers for wiring
	public static final int leftfront = 0;
	public static final int leftrear = 2;
	public static final int rightfront = 1;
    public static final int rightrear = 3;
    public static final int Joystick_Left_X_Axis = 0;
    public static final int Joystick_left_Y_Axis = 1;
	public static final double DriveTrainSpeed = 0.7;
	public static final double AutonomousSpeed = 0.4;
	public static final double DriveForwardTime = 3;//seconds
	public static final int JoystickNumber = 0;// 
	//go to drive station and have controller plugged into usb go to 4th one down and move around to see what number axis is
}
