// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class motorGo extends SubsystemBase {
  
  private final SparkMax motor = new SparkMax(3, MotorType.kBrushless);
  RelativeEncoder re = motor.getEncoder();
  //PIDController PidCon = new PIDController(0.0004, .00013, 0.00001);
  PIDController PidCon = new PIDController(0.0004, .00013, 0.000016);

  public motorGo() {}

  public Double getMotorSpeed() {
    Double motorSpeed = PidCon.calculate(re.getVelocity(), 1000);
    
    return motorSpeed;
  }

public void motorSpin() {
//motor.set(100);

  //System.out.println(speed);
  motor.set(getMotorSpeed());
  //System.out.println(re.getPosition());

  SmartDashboard.putNumber("gyro angle", re.getPosition());
  SmartDashboard.putNumber("motorrd velo", re.getVelocity());
}



}
