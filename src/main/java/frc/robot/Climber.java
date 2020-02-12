package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
public class Climber{
    TalonSRX cMotor, cMotor1;
    DoubleSolenoid solenoid1, solenoid2;
    Boolean extended, exdown;
    DigitalInput uplimit, downlimit;
    public Climber(int c, int c1, int s, int s1, int up, int down) {
        cMotor = new TalonSRX(c);
        cMotor1 = new TalonSRX(c1);
        cMotor1.follow(cMotor);
        solenoid1 = new DoubleSolenoid(s, s1);
        uplimit = new DigitalInput(up);
        downlimit = new DigitalInput(down);
    }
    
    public void climb(){
        if (extended && !exdown){
            solenoid1.set(DoubleSolenoid.Value.kReverse);
            cMotor.set(ControlMode.PercentOutput, -0.5);
            extended=!extended;
            exdown = true;
        }
        else if(!exdown){
            solenoid1.set(DoubleSolenoid.Value.kReverse);
            cMotor.set(ControlMode.PercentOutput, -0.5);
            extended=!extended;
            exdown = true;
        }
        else {
            exdown=false;
        } 
        if (!downlimit.get() && extended){

        }  
    }
}
