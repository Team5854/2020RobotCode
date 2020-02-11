package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Climber{
    TalonSRX cMotor;
    public Climber(int c) {
        cMotor = new TalonSRX(c);
    }
    public void climb(){
        
    }
}