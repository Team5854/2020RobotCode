package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
public class Climber{
    TalonSRX cMotor, cMotor1;
    DoubleSolenoid solenoid1, solenoid2;
    Boolean goingUp;
    DigitalInput uplimit, downlimit;
    public Climber(int c, int c1, int s, int s1, int lup, int ldown) {
        cMotor = new TalonSRX(c);
        cMotor1 = new TalonSRX(c1);
        cMotor1.follow(cMotor);
        cMotor1.setInverted(true);
        solenoid1 = new DoubleSolenoid(s, s1);
        uplimit = new DigitalInput(lup);
        downlimit = new DigitalInput(ldown);
    }
   
    public void climb(boolean button){
        if(button){
            goingUp = !goingUp;
        }
        if(!uplimit.get() && goingUp){
            // Move motors up here
        }
        if(!downlimit.get() && !goingUp){
            // Move motors down here
        }
    }

    public void move(boolean up, boolean down){
        if(up){
            if(!uplimit.get()){
                cMotor.set(ControlMode.PercentOutput, .4);
            }
        }
        else if(down){
            if (!downlimit.get()){
                cMotor.set(ControlMode.PercentOutput, -.4);
            }
        }
        else{
            cMotor.set(ControlMode.PercentOutput, 0);
        }
    }
    public void solenoid(boolean brake, boolean release){
        if (brake){
            solenoid1.set(DoubleSolenoid.Value.kForward);
        }
        else if (release){
            solenoid1.set(DoubleSolenoid.Value.kForward);
        }
    }
}