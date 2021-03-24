// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

CANSparkMax leftfront = new CANSparkMax(5, MotorType.kBrushless);
CANSparkMax rightfront = new CANSparkMax(7, MotorType.kBrushless); 
CANSparkMax leftrear = new CANSparkMax(4, MotorType.kBrushless);
CANSparkMax rightrear = new CANSparkMax(6, MotorType.kBrushless);

boolean trigger = true;

CANSparkMax Wash = new CANSparkMax(2, MotorType.kBrushed);
CANSparkMax Shooter = new CANSparkMax(9, MotorType.kBrushless);
CANSparkMax ElevatorLeft = new CANSparkMax(10, MotorType.kBrushed);
CANSparkMax ElevatorRight = new CANSparkMax(11, MotorType.kBrushed);
CANSparkMax Collector = new CANSparkMax(3, MotorType.kBrushed); 

double rotate = 0.75;
double speed = 0.75;

Joystick leftstick = new Joystick(0);
Joystick rightstick = new Joystick(1);
Joystick codriverstick = new Joystick(2);


SpeedControllerGroup leftside = new SpeedControllerGroup(leftfront, leftrear);
SpeedControllerGroup rightside = new SpeedControllerGroup (rightfront, rightrear);


  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic () {


    if(codriverstick.getRawButtonReleased(2) && trigger ==true){
      trigger = false;
    }

else {

  trigger = false;
}

if(codriverstick.getRawButton(2)==true){

Wash.set(-1.0);

}
else{
  Wash.set(0);
}
    leftside.set(leftstick.getRawAxis(1));
    rightside.set(rightstick.getRawAxis(1)*-1);

//Shooter Hopefully
if(codriverstick.getRawButton(1)==true){
  Shooter.set(-1.0);} 
      
  else{
    Shooter.set(0);
  
 //Collector
if(leftstick.getRawButton(1)==true){
  Collector.set(-1.0);} 

  if(leftstick.getRawButton(2)==true){
      Collector.set(1.0);} 
      
else{
      Collector.set(0);
//Elevator
if(codriverstick.getRawButton(3)==true){
  ElevatorLeft.set(-1.0);} 
      
if(leftstick.getRawButton(4)==true){
  ElevatorLeft.set(1.0);} 
            
else{
  ElevatorLeft.set(0);

if(codriverstick.getRawButton(3)==true){
  ElevatorRight.set(-1.0);} 
        
if(leftstick.getRawButton(4)==true){
  ElevatorRight.set(1.0);} 

else{
  ElevatorRight.set(0);}}}}
}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}