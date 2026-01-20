// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import org.littletonrobotics.junction.AutoLog;

/** Add your docs here. */
public interface ShooterInterface {
     @AutoLog
  public static class ShooterInputs { // For values
    public double topFlywheelRPM = 0.0;
    public double topMotorVoltage = 0.0;
    public double topDutyCycle = 0.0;
    public double topDesiredRPM = 0.0;
    public double topStatorCurrent = 0.0;
    public double topMotorVelocity = 0.0;
    public double topRPMError = 0.0;
    public double topMotorTemp = 0.0;

    public double bottomFlywheelRPM = 0.0;
    public double bottomMotorVoltage = 0.0;
    public double bottomDutyCycle = 0.0;
    public double bottomDesiredRPM = 0.0;
    public double botomStatorCurrent = 0.0;
    public double botomMotorVelocity = 0.0;
    public double bottomRPMError = 0.0;
    public double botomMotorTemp = 0.0;

  }

  public default void updateInputs(ShooterInputs inputs) {}

  public default double getTopFlywheelRPM() {
    return 0.0;
  }

  public default double getBottomFlywheelRPM() {
    return 0.0;
  }

  public default void setFlywheelRPM(double topRPM, double bottomRPM) {}

  public default void setVolts(double topVolts, double bottomVolts) {}

  public default void setPercentOutput(double topOutput, double bottomOutput) {}

  public default double getTopVolts() {
    return 0.0;
  }

  public default double getBottomVolts() {
    return 0.0;
  }


  public default void openLoop(double topOutput, double bottomOutput) {}

  public default void setTopPID(double kP, double kI, double kD) {}

  public default void setBottomPID(double kP, double kI, double kD) {}

  public default void setTopFF(double kS, double kV, double kA, double kG) {}

  public default void setBottomFF(double kS, double kV, double kA, double kG) {}
}
