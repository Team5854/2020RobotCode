package frc.robot.mechanisms;
import edu.wpi.first.wpilibj.SerialPort;
public class Cargo {
    public Cargo() {
    }
    public void send(String input){
        SerialPort arduino = new SerialPort(9600, SerialPort.Port.kUSB);
        arduino.flush();
        arduino.writeString(input);
    }
}