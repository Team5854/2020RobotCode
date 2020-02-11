package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;


public class Robot extends TimedRobot {
  Drivetrain drivetrain;
  SerialPort arduino;
  


  @Override
  public void robotInit() {
    arduino = new SerialPort(9600, Port.kUSB);
    drivetrain = new Drivetrain(0,1,2,3);
  }


  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    System.out.println("Boo Corbin!");
    arduino.writeString("B");
  }
  @Override
  public void teleopInit() {
    System.out.println("Boo Corbin!");
    arduino.writeString("A");
  }


  
  @Override
  public void autonomousPeriodic() {
    
  }

 
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testPeriodic() {
  }
}
