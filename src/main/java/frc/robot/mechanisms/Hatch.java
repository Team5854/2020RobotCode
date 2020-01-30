/*
package frc.robot.mechanisms;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Hatch {
    //private static TalonSRX mcontroller = new TalonSRX(5);
    private static double speed = 0.5;
    private static DoubleSolenoid solenoid = new DoubleSolenoid(14, 6, 7);
    private static boolean resetSolenoid = false;
   // private static DigitalInput limit = new DigitalInput(3);
    public static void actuate(boolean up, boolean down, boolean release) {
        // if (up) {
        //     mcontroller.set(ControlMode.PercentOutput, speed);
        // } else if (down) {
        //     //if (!limit.get()) {
        //         mcontroller.set(ControlMode.PercentOutput, -speed);
        //     //} else {
        //        // mcontroller.set(ControlMode.PercentOutput, 0 );
        //    // }
        // } else {
        //     mcontroller.set(ControlMode.PercentOutput, 0);
        // }
            System.out.println("Solinoild");
        if (release) {
            solenoid.set(Value.kForward);
            resetSolenoid = true;
        } else {
            if (resetSolenoid) {
                solenoid.set(Value.kReverse);
                resetSolenoid = false;
            } else {
                solenoid.set(Value.kOff);
            }
        }
    }
}
*/