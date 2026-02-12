// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.motorGo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.ctre.phoenix6.hardware.Pigeon2;

public class RobotContainer {

  private final GenericHID buttonbox = new GenericHID(1);

   private final CommandXboxController controller = new CommandXboxController(0);
  private final motorGo motorGo = new motorGo();


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    //button # calls command
    JoystickButton coinButton = new JoystickButton(buttonbox, 10);
    JoystickButton humanButton = new JoystickButton(buttonbox, 9);
    JoystickButton onethButton = new JoystickButton(buttonbox, 1);
    
    /*coinButton.onTrue(new cheeseBalls(s_MotorGo));
    coinButton.onFalse(new motorNoGo(s_MotorGo));*/

    coinButton.onTrue(new RunCommand(() -> motorGo.motorSpin(), motorGo));
    //coinButton.onFalse(new motorNoGo(s_MotorGo));

    
    //Pigeon2 gyroiPigeon = new Pigeon2(29);

    //onethButton.toggleOnTrue(new gyromotor(s_MotorGo));

    //coinButton.onFalse(new motorNoGo(s_MotorGo));

    //coinButton.onTrue(new cheeseBalls(s_MotorGo));
    //coinButton.onFalse(new motorNoGo(s_MotorGo));
  }
  

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }



}