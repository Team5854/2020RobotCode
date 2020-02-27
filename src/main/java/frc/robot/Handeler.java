package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
public class Handeler{
    int counter = 0;
    final double iSpeed = .25;
    double distance = 0;
    TalonSRX haMotor, inMotor, e1Motor, e2Motor, s1Motor, s2Motor;
    DoubleSolenoid extend;
    boolean extended, exdown;
    public Handeler(final int ha, final int in, final int e1, final int e2, final int s1, final int s2) {

// deleted due to no harvest: , final int ex, final int ex1

        haMotor = new TalonSRX(ha);
        inMotor = new TalonSRX(in);
        e1Motor = new TalonSRX(e1);
        e2Motor = new TalonSRX(e2);
        s1Motor = new TalonSRX(s1);
        s2Motor = new TalonSRX(s2);
        e2Motor.follow(e1Motor);
        s2Motor.follow(s1Motor);
        e1Motor.setInverted(true);
        inMotor.setInverted(true);
        s1Motor.setInverted(true);
        s2Motor.setInverted(true);
        //extend = new DoubleSolenoid(ex, ex1);
    }

    public void control(final boolean intake, final boolean shoot, final boolean harvest){
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

        if(counter > 5 && !harvest){
            //extend.set(DoubleSolenoid.Value.kReverse);
        }
       
        if (shoot){
        }
       
        if (harvest){
            if (extended && !exdown){
                //extend.set(DoubleSolenoid.Value.kReverse);
                extended=!extended;
                exdown = true;
            }
            else if(!exdown){
                //extend.set(DoubleSolenoid.Value.kForward);
                extended=!extended;
                exdown = true;
               
            }
        }
       
        else {
            exdown=false;
        }
    }

    public void attack(final boolean go, final boolean shoot){
        if (go){
            haMotor.set(ControlMode.PercentOutput, .35);
            inMotor.set(ControlMode.PercentOutput, .35);
            e1Motor.set(ControlMode.PercentOutput, .45);
        }
        else{
            haMotor.set(ControlMode.PercentOutput, 0);
            inMotor.set(ControlMode.PercentOutput, 0);
            e1Motor.set(ControlMode.PercentOutput, 0);
        }
        if (shoot){
            s1Motor.set(ControlMode.PercentOutput, 0.8);
        }
        else{
            s1Motor.set(ControlMode.PercentOutput, 0);
        }
    }
}