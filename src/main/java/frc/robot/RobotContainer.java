// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CollectorCommands;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveTrainCommands;
import frc.robot.commands.ShooterCommands;
import frc.robot.commands.WashingCommands;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.WashingMachine;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final Joystick leftstick = new Joystick(0);
  private final Joystick rightstick = new Joystick(1);
  private final Joystick codriverstick = new Joystick(2);



  private final DriveTrain  m_drivetrain = new DriveTrain();
  private final Collector m_collector = new Collector();
  private final Elevator m_elevator = new Elevator();
  private final Shooter m_shooter = new Shooter();
  private final WashingMachine m_washingMachine = new WashingMachine();

  private final CommandBase m_autonomousCommand =
      new DriveForwardTimed(m_drivetrain);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   
    //DriveTrainCommands = new DriveTrainCommands(drivetrain);
    //DriveTrainCommands.addRequirements(drivetrain);
    m_drivetrain.setDefaultCommand(new DriveTrainCommands(leftstick, rightstick, m_drivetrain));

   

   
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //if(codriverstick.getRawButton(2)==true){

//Wash.set(-1.0);

//}
//else{
//  Wash.set(0);
//}
    final JoystickButton washbutton = new JoystickButton(codriverstick, 2);
    washbutton.whileHeld(new WashingCommands(m_washingMachine));

    //if(codriverstick.getRawButton(1)==true){
      //Shooter.set(-1.0);} 
          
      //else{
       // Shooter.set(0);

    final JoystickButton shooterButton = new JoystickButton(codriverstick, 1);
    shooterButton.whileHeld(new ShooterCommands(m_shooter));

    //if(leftstick.getRawButton(1)==true){
    //  Collector.set(-1.0);} 
    final JoystickButton collectorButton = new JoystickButton(leftstick,1);
    collectorButton.whileHeld(new CollectorCommands(m_collector));




    /* ***************************************************************
                      Create Buttons and set up commands
     **************************************************************** */

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
   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous !!!!!!!!!
    return m_autonomousCommand;
  }
}