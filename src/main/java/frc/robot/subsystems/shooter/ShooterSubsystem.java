// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import java.util.function.DoubleSupplier;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.swerve.SwerveModule;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extras.logging.LoggedTunableNumber;

public class ShooterSubsystem extends SubsystemBase {
  private ShooterInterface shooterInterface;
  private ShooterInputsAutoLogged inputs = new ShooterInputsAutoLogged();
 
  private static final LoggedTunableNumber topS =
      new LoggedTunableNumber("Shooter/ShooterS");
  private static final LoggedTunableNumber topV =
      new LoggedTunableNumber("Shooter/ShooterV");
  private static final LoggedTunableNumber topA =
      new LoggedTunableNumber("Shooter/ShooterA");
  private static final LoggedTunableNumber topG =
      new LoggedTunableNumber("Shooter/ShooterG");
  private static final LoggedTunableNumber topP =
      new LoggedTunableNumber("Shooter/ShooterP");
  private static final LoggedTunableNumber topI =
      new LoggedTunableNumber("Shooter/ShooterI");
  private static final LoggedTunableNumber topD =
      new LoggedTunableNumber("Shooter/ShooterD");

  private static final LoggedTunableNumber bottomS =
      new LoggedTunableNumber("Shooter/ShooterS");
  private static final LoggedTunableNumber bottomV =
      new LoggedTunableNumber("Shooter/ShooterV");
  private static final LoggedTunableNumber bottomA =
      new LoggedTunableNumber("Shooter/ShooterA");
  private static final LoggedTunableNumber bottomG =
      new LoggedTunableNumber("Shooter/ShooterG");
  private static final LoggedTunableNumber bottomP =
      new LoggedTunableNumber("Shooter/ShooterP");
  private static final LoggedTunableNumber bottomI =
      new LoggedTunableNumber("Shooter/ShooterI");
  private static final LoggedTunableNumber bottomD =
      new LoggedTunableNumber("Shooter/ShooterD");

  static {
    switch (Constants.getRobot()) {
      case COMP_ROBOT, DEV_ROBOT -> {
        topS.initDefault(ShooterConstants.TOP_SHOOTER_S);
        topV.initDefault(ShooterConstants.TOP_SHOOTER_V);
        topA.initDefault(ShooterConstants.TOP_SHOOTER_A);
        topG.initDefault(ShooterConstants.TOP_SHOOTER_G);
        topP.initDefault(ShooterConstants.TOP_SHOOTER_P);
        topI.initDefault(ShooterConstants.TOP_SHOOTER_I);
        topD.initDefault(ShooterConstants.TOP_SHOOTER_D);

        bottomS.initDefault(ShooterConstants.BOTTOM_SHOOTER_S);
        bottomV.initDefault(ShooterConstants.BOTTOM_SHOOTER_V);
        bottomA.initDefault(ShooterConstants.BOTTOM_SHOOTER_A);
        bottomG.initDefault(ShooterConstants.BOTTOM_SHOOTER_G);
        bottomP.initDefault(ShooterConstants.BOTTOM_SHOOTER_P);
        bottomI.initDefault(ShooterConstants.BOTTOM_SHOOTER_I);
        bottomD.initDefault(ShooterConstants.BOTTOM_SHOOTER_D);
      }
    }
  }

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem(ShooterInterface shooterInterface) {
    this.shooterInterface = shooterInterface;
  }

  public double getTopFlywheelRPM() {
    return shooterInterface.getTopFlywheelRPM();
  }

   public double getBottomFlywheelRPM() {
    return shooterInterface.getBottomFlywheelRPM();
  }

  public double getTopVolts() {
    return shooterInterface.getTopVolts();
  }

  public double getBottomVolts() {
    return shooterInterface.getBottomVolts();
  }

  public void setFlywheelRPM(double topRPM, double bottomRPM) {
    shooterInterface.setFlywheelRPM(topRPM, bottomRPM);
  }

  public double getTopVelocity() {
    return inputs.topMotorVelocity;
  }

  public double getBottomVelocity() {
    return inputs.bottomMotorVelocity;
  }

  public void setVolts(double topVolts, double bottomVolts) {
    shooterInterface.setVolts(topVolts, bottomVolts);
  }

  public void openLoop(double topOutput, double bottomOutput) {
    shooterInterface.openLoop(topOutput, bottomOutput);
  }

  public void setPercentOutput(double topOutput, double bottomOutput) {
    shooterInterface.setPercentOutput(topOutput, bottomOutput);
  }

  public boolean isTopAtSetpointRPM(double topRPM) {
    return Math.abs(topRPM - inputs.topFlywheelRPM)
        < ShooterConstants.TOP_FLYWHEEL_ERROR_TOLERANCE;
  }

  public boolean isBottomAtSetpointRPM(double bottomRPM) {
    return Math.abs(bottomRPM - inputs.bottomFlywheelRPM)
        < ShooterConstants.BOTTOM_FLYWHEEL_ERROR_TOLERANCE;
  }


  @Override
  public void periodic() {
    shooterInterface.updateInputs(inputs);
    Logger.processInputs("Shooter/", inputs);

    // Update tunable numbers
    if (topS.hasChanged(hashCode())
        || topV.hasChanged(hashCode())
        || topA.hasChanged(hashCode())
        || topG.hasChanged(hashCode())) {
      shooterInterface.setTopFF(topS.get(), topV.get(), topA.get(), topG.get());
    }
    if (topP.hasChanged(hashCode())
        || topI.hasChanged(hashCode())
        || topD.hasChanged(hashCode())) {
      shooterInterface.setTopPID(topP.get(), topI.get(), topD.get());
    }

    if (bottomS.hasChanged(hashCode())
        || bottomV.hasChanged(hashCode())
        || bottomA.hasChanged(hashCode())
        || bottomG.hasChanged(hashCode())) {
      shooterInterface.setBottomFF(bottomS.get(), bottomV.get(), bottomA.get(), bottomG.get());
    }
    if (bottomP.hasChanged(hashCode())
        || bottomI.hasChanged(hashCode())
        || bottomD.hasChanged(hashCode())) {
      shooterInterface.setBottomPID(bottomP.get(), bottomI.get(), bottomD.get());
    }
  }


  // public Command setFlywheelRPM(double topRPM, double bottomRPM) {
  //   return new FunctionalCommand(
  //       // initialization function
  //       () -> ,
  //       // execution function
  //       () -> this.setShooterPosition(position),
  //       // end function
  //       interrupted -> this.setShooterPosition(position),
  //       // isFinished function
  //       () -> isAtSetpoint(position),
  //       this);
  // }
}
