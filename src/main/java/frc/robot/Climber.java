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
    public Climber(int c, int c1, int s, int s1, int up, int down) {
        cMotor = new TalonSRX(c);
        cMotor1 = new TalonSRX(c1);
        cMotor1.follow(cMotor);
        solenoid1 = new DoubleSolenoid(s, s1);
        uplimit = new DigitalInput(up);
        downlimit = new DigitalInput(down);
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

}
