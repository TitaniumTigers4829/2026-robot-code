package frc.robot.subsystems.adjustableHood;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.ParentDevice;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.HardwareConstants;
import frc.robot.extras.logging.LoggedTunableNumber;
import frc.robot.extras.math.interpolation.SingleLinearInterpolator;


public class PhysicalAdjust implements AdjustableHoodInterface{

    @Override
    public void resetHoodPID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetHoodPID'");
    }}
