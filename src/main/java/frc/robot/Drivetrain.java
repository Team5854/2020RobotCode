package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Drivetrain {
    TalonSRX flMotor, frMotor, brMotor, blMotor;
    public Drivetrain(int fl, int fr, int bl, int br) {
        frMotor = new TalonSRX(fr);
        flMotor = new TalonSRX(fl);
        blMotor = new TalonSRX(bl);
        brMotor = new TalonSRX(br);
        brMotor.follow(frMotor);
        blMotor.follow(flMotor);

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

