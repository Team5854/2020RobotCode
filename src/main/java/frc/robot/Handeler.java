package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Handeler{
    int counter = 0;
    final double iSpeed = .25;
    double distance = 0;
    TalonSRX haMotor, inMotor, e1Motor, e2Motor, s1Motor, s2Motor;
    Solenoid singlesol;
    boolean extended, exdown;
    AnalogInput irLog, loadSensor;
    double ballDistanceShaft;
    boolean traveling = false, auto = true, toggle = false;
    int delay;
    public Handeler(final int ha, final int in, final int e1, final int e2, final int s1, final int s2, final int eSensor , int Joe, int solenoid) {

// deleted due to no harvest: , final int ex, final int ex1

        haMotor = new TalonSRX(ha);
        inMotor = new TalonSRX(in);
        e1Motor = new TalonSRX(e1);
        e2Motor = new TalonSRX(e2);
        s1Motor = new TalonSRX(s1);
        s2Motor = new TalonSRX(s2);
        irLog = new AnalogInput(eSensor);
        loadSensor = new AnalogInput(Joe);
        singlesol = new Solenoid(solenoid);
        s2Motor.configFactoryDefault();
        //e2Motor.follow(e1Motor);
        s2Motor.follow(s1Motor);
        e1Motor.setInverted(true);
        inMotor.setInverted(true);
        s1Motor.setInverted(true);
        s1Motor.configFactoryDefault();
        s2Motor.setInverted(true);

        //extend = new DoubleSolenoid(ex, ex1);
    }

    /*
    public void control(final boolean intake, final boolean shoot, final boolean harvest){
        if (intake){
            singlesol.set(true);
            haMotor.set(ControlMode.PercentOutput, iSpeed);
            inMotor.set(ControlMode.PercentOutput, iSpeed);
            e1Motor.set(ControlMode.PercentOutput, iSpeed);
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
            singlesol.set(false);
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
*/
    public void attack(final boolean go, final boolean shoot, final boolean elevator, final boolean edown, final boolean disable){
        //System.out.println(irLog.getAverageValue());
        if (disable && !toggle){
            auto = !auto;
            toggle = true;
            System.out.println(auto);
            SmartDashboard.putBoolean("Brake", auto);
        }
        else if (disable && toggle){
        }
        else{
            toggle = false;
        }
        if (go){
            haMotor.set(ControlMode.PercentOutput, .5);
            inMotor.set(ControlMode.PercentOutput, .5);
        // e1Motor.set(ControlMode.PercentOutput, .45);
            singlesol.set(true);
        }  
        else{
            haMotor.set(ControlMode.PercentOutput, 0);
            inMotor.set(ControlMode.PercentOutput, 0);
            //e1Motor.set(ControlMode.PercentOutput, 0);
            singlesol.set(false);
        }
        if (shoot){
            s1Motor.set(ControlMode.PercentOutput, 0.8);
            System.out.println(s2Motor.getSelectedSensorVelocity());

        }
        else{
            s1Motor.set(ControlMode.PercentOutput, 0);
        }

        if (elevator){
            e1Motor.set(ControlMode.PercentOutput, 1);
            e2Motor.set(ControlMode.PercentOutput, 1);
            inMotor.set(ControlMode.PercentOutput, 1);
        }
        else if (edown) {
            e1Motor.set(ControlMode.PercentOutput, -.4);
            e2Motor.set(ControlMode.PercentOutput, -.4);
        }
        if(!elevator && !edown) {
            e1Motor.set(ControlMode.PercentOutput, 0);
            e2Motor.set(ControlMode.PercentOutput, 0);
        }
        if (traveling){
            counter --;
            
            inMotor.set(ControlMode.PercentOutput, 0.1);
            e1Motor.set(ControlMode.PercentOutput, 0.90);
            e2Motor.set(ControlMode.PercentOutput, -.1);
            if (counter <= 0){
                traveling = false;
                e1Motor.set(ControlMode.PercentOutput, 0);
                e2Motor.set(ControlMode.PercentOutput, 0);
                inMotor.set(ControlMode.PercentOutput, 0);
            }
        }
        else{
            if (auto){
                
                if(loadSensor.getAverageValue() >= 1000){
                //Move Intake Shaft
                    if (!traveling){
                        traveling = true;
                        counter = 45;
                    }
                }
            }
        }
    }
}