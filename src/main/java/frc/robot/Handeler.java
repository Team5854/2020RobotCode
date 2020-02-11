package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Handeler{
    int counter = 0;
    final double iSpeed = .25;
    double distance = 0;
    TalonSRX haMotor, inMotor, e1Motor, e2Motor, s1Motor, s2Motor;
    public Handeler(int ha, int in, int e1, int e2, int s1, int s2) {
        haMotor = new TalonSRX(ha);
        inMotor = new TalonSRX(in);
        e1Motor = new TalonSRX(e1);
        e2Motor = new TalonSRX(e2);
        s1Motor = new TalonSRX(s1);
        s2Motor = new TalonSRX(s2);
        e2Motor.follow(e1Motor);
        s2Motor.follow(s1Motor);
    }
    public void control(boolean intake, boolean shoot){
        if (intake){
            haMotor.set(ControlMode.PercentOutput, iSpeed);
            inMotor.set(ControlMode.PercentOutput, iSpeed);
            if (counter < 5 && distance<10){
                e1Motor.set(ControlMode.PercentOutput, iSpeed);
            }
            else {
                e1Motor.set(ControlMode.PercentOutput, 0);
            }
        }
        else{
            haMotor.set(ControlMode.PercentOutput, 0);
            inMotor.set(ControlMode.PercentOutput, 0);
        }
        


        
        if (shoot){

        }
    }
}