package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Drivetrain {
    TalonSRX flMotor, frMotor, brMotor, blMotor;
    double rospeed = 0, fbspeed = 0;
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
    public void arcade(double fb, double ro, boolean boost){ 
        if (rospeed < ro){
            rospeed+=0.1;
        }
        else if (rospeed > ro){
            rospeed-= 0.1;
        }
        if (fbspeed < fb){
            fbspeed+=0.05;
        }
        else if (fbspeed > fb){
            fbspeed-= 0.05;
        }
        double r = fbspeed - (rospeed);
        double l = fbspeed + (rospeed);
        if (boost){
        frMotor.set(ControlMode.PercentOutput, l);
        flMotor.set(ControlMode.PercentOutput, r);
        } 
        else{
        frMotor.set(ControlMode.PercentOutput, l*0.5);
        flMotor.set(ControlMode.PercentOutput, r*0.5);
        }
    }
}