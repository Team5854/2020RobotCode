package frc.robot;
<<<<<<< HEAD
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
}

=======

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drivetrain {
	private TalonSRX frontLeft, backLeft, frontRight, backRight;
	public Drivetrain(int frontLeftID, int frontRightID, int backLeftID, int backRightID, int frontmidLeftID, int frontmidRightID, int backmidLeftID, int backmidRightID)	{
		frontLeft = new TalonSRX(frontLeftID);
		backLeft = new TalonSRX(backLeftID);
		frontRight = new TalonSRX(frontRightID);
    	backRight = new TalonSRX(backRightID);
    	TalonSRX frontmidLeft = new TalonSRX(frontmidLeftID);
    	frontmidLeft.set(ControlMode.Follower, frontLeft.getDeviceID());
    	TalonSRX backmidLeft = new TalonSRX(backmidLeftID);
    	backmidLeft.set(ControlMode.Follower, backLeft.getDeviceID());
    	TalonSRX frontmidRight = new TalonSRX(frontmidRightID);
    	frontmidRight.set(ControlMode.Follower, frontRight.getDeviceID());
    	TalonSRX backmidRight = new TalonSRX(backmidRightID);
    	backmidRight.set(ControlMode.Follower, backRight.getDeviceID());
    	
    	frontLeft.setInverted(true);
		frontRight.setInverted(true);
		backLeft.setInverted(true);
		backRight.setInverted(false);

		frontmidLeft.setInverted(true);
		frontmidRight.setInverted(true);
		backmidLeft.setInverted(true);
		backmidRight.setInverted(false);
	}
	
	public void drive(double y, double x, double r) {
		if(Math.abs(y)< 0.05) {
			y = 0;
		}
		if(Math.abs(x)< 0.05) {
			x = 0;
		}
		if(Math.abs(r)< 0.05) {
			r = 0;
		}
		y /= 2;
		//x /= 2;
		r /= 2;
		double frontLeft = y-x-r;
		double frontRight = y+x+r;
		double backLeft = y+x-r;
		double backRight = y-x+r;
		this.frontLeft.set(ControlMode.PercentOutput, frontLeft);
		this.frontRight.set(ControlMode.PercentOutput, frontRight);
		this.backLeft.set(ControlMode.PercentOutput, backLeft);
		this.backRight.set(ControlMode.PercentOutput, backRight);
	
	
	}
}


	



>>>>>>> 011fa65d5d9d207ece897134e324cce4dcf0051d
