package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Drivetrain {
    TalonSRX flMotor, frMotor, brMotor, blMotor;
    public Drivetrain(int fl, int fr, int bl, int br, boolean flInvert, boolean frInvert, boolean blInvert, boolean brInvert) {
        frMotor = new TalonSRX(fr);
        flMotor = new TalonSRX(fl);
        blMotor = new TalonSRX(bl);
        brMotor = new TalonSRX(br);
        brMotor.follow(frMotor);
        blMotor.follow(flMotor);

        frMotor.setInverted(flInvert);
        frMotor.setInverted(frInvert);
        frMotor.setInverted(blInvert);
        frMotor.setInverted(brInvert);
    }
    public void drive(double l, double r){
        frMotor.set(ControlMode.PercentOutput, r);
        flMotor.set(ControlMode.PercentOutput, l);
    }
    public void arcade(double fb, double ro){
        double r = fb - ro;
        double l = fb + ro; 
        frMotor.set(ControlMode.PercentOutput, r);
        flMotor.set(ControlMode.PercentOutput, l);
    }
}