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
  }

  public default void updateInputs(ShooterInputs inputs) {}

  public default double getFlywheelRPM() {
    return 0.0;
  }

  public default void setFlywheelRPM(double targetRPM) {}

  public default void setVolts(double volts) {}

  public default void setPercentOutput(double output) {}

  public default double getVolts() {
    return 0.0;
  }



  public default void openLoop(double output) {}

  public default void setPID(double kP, double kI, double kD) {}

  public default void setFF(double kS, double kV, double kA) {}
}
