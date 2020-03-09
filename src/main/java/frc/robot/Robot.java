package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  Drivetrain drivetrain;
  Joystick driver, driver2;
  Handeler handeler;
  Climber climber;
  //Arduino arduino;
  Compressor c;
 


  @Override
  public void robotInit() {
    SmartDashboard.putBoolean("Brake", false);
    //arduino = new SerialPort(9600, Port.kUSB);
    //arduino = new Arduino();
    drivetrain = new Drivetrain(2,3,4,5,false,false,false,false);
    handeler= new Handeler(13,7,8,9,10,11,0,1,2);
    driver = new Joystick(0);
    try{
      driver2 = new Joystick(1);
    }
    catch(Exception e){
      System.out.println("Second is gone");
    }
    climber = new Climber(1,6,0,2,9,8);
    c = new Compressor(0);
  }


  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    System.out.println("Boo Corbin!");
    //arduino.writeString("B");
  }
  @Override
  public void teleopInit() {
    System.out.println("Boo Corbin!");
    //arduino.writeString("A");
    c.start();
		c.setClosedLoopControl(true);
  }


 
  @Override
  public void autonomousPeriodic() {
  }

 
  @Override
  public void teleopPeriodic() {
    if (false){
      drivetrain.arcade(driver.getRawAxis(1) , driver.getRawAxis(0), driver.getRawButton(5));
      handeler.attack(driver.getRawButton(1), driver.getRawButton(2), driver.getRawButton(6), driver.getRawButton(8), driver.getRawButton(7));
      climber.move(driver.getRawButton(4), driver.getRawButton(3));
    }
    else{
      drivetrain.arcade(driver.getRawAxis(1) , driver.getRawAxis(2), driver.getRawButton(8));
      handeler.attack(driver2.getRawButton(1), driver2.getRawButton(2), driver2.getRawButton(6), driver2.getRawButton(8), driver2.getRawButton(7));
      climber.move(driver2.getRawButton(4), driver2.getRawButton(3));
    }
    //climber.solenoid(driver.getRawButton(6), driver.getRawButton(8));
    //arduino.get();

  }

  @Override
  public void testPeriodic() {
  }
}