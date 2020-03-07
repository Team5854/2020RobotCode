package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Drivetrain {
    TalonSRX flMotor, frMotor, brMotor, blMotor;
    public Drivetrain(int fl, int bl, int fr, int br, boolean flInvert, boolean frInvert, boolean blInvert, boolean brInvert) {
        frMotor = new TalonSRX(fr);
        flMotor = new TalonSRX(fl);
        blMotor = new TalonSRX(bl);
        brMotor = new TalonSRX(br);
        brMotor.follow(frMotor);
        blMotor.follow(flMotor);

        flMotor.setInverted(true);
        blMotor.setInverted(true);
        //.setInverted(frInvert);
        //frMotor.setInverted(blInvert);
        //brMotor.setInverted(brInvert);
    }
    public void drive(double l, double r){
        frMotor.set(ControlMode.PercentOutput, r);
        flMotor.set(ControlMode.PercentOutput, l);
    }
    public void arcade(double fb, double ro){ 
        double r = fb - ro;
        double l = fb + ro; 
        frMotor.set(ControlMode.PercentOutput, l*0.5);
        flMotor.set(ControlMode.PercentOutput, r*0.5);
    }
}