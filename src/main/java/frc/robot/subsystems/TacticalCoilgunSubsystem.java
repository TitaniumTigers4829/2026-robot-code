// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TacticalCoilgunSubsystem extends SubsystemBase {
  private final TalonFX windup;
  private String railOne;
  private String railTwo;
  private int projectile;
  private int timesShoot;
  private boolean isSwitchOn;
  private boolean isEnergized;
  private boolean isOverheating;
  private Pose2d projectilePose;
  private double speed;

  public TacticalCoilgunSubsystem() {

    windup = new TalonFX(0);
    railOne = "";
    railTwo = "";
    projectile = 20;
    timesShoot = 0;
    isSwitchOn = false;
    isEnergized = false;
    projectilePose = new Pose2d();
    speed = 0.0;
  }

  public void shoot(int projectilesLeft) {

  }

  public boolean isGunOverheating(int timesShoot) { 
    return true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /*
   * wasd = move
   * fire projectile
   * trigger (button)
   * turret mech
   */

  
}
