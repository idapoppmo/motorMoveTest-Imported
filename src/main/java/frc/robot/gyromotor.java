// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class gyromotor extends Command {
  /** Creates a new cheeseBalls. */

  //private final pigeonThing s_PigeonThing = new pigeonThing();
    
  Pigeon2 gyroiPigeon = new Pigeon2(29);

  motorGo s_gyrogo;
  public gyromotor(motorGo s_PigeonThing2) {
    // Use addRequirements() here to declare subsystem dependencies.
    s_gyrogo = s_PigeonThing2;

    addRequirements(s_gyrogo);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  System.out.println(gyroiPigeon.getAccelerationY().getValueAsDouble());

    //if (gyroiPigeon.getAccelerationY().getValueAsDouble() > 0.6) {
         //s_gyrogo.motorSpin(gyroiPigeon.getYaw().getValueAsDouble());
         s_gyrogo.motorSpin();
         
    //} else {
     //  s_gyrogo.motorSpin(0.0);
    //}
     

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
