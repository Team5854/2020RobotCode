package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;


public class Robot extends TimedRobot {
  Drivetrain drivetrain;
  Joystick driver;
  Handeler handeler;
  Climber climber;
  Arduino arduino;
 


  @Override
  public void robotInit() {
    //arduino = new SerialPort(9600, Port.kUSB);
    arduino = new Arduino();
    drivetrain = new Drivetrain(2,3,4,5,false,false,false,false);
    handeler= new Handeler(13,7,8,9,10,11);
    driver = new Joystick(0);
    climber = new Climber(1,12);
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
  }


 
  @Override
  public void autonomousPeriodic() {
   
  }

 
  @Override
  public void teleopPeriodic() {
    drivetrain.arcade(driver.getRawAxis(1) , driver.getRawAxis(2));
    handeler.attack(driver.getRawButton(1), driver.getRawButton(2));
    climber.move(driver.getRawButton(4), driver.getRawButton(3));
    arduino.get();

  }

  @Override
  public void testPeriodic() {
  }
}