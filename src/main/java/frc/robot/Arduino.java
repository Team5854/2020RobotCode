package frc.robot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class Arduino {
    String lidar = "0";
    String analog = "0";
    String baby = "0";
    SerialPort arduino;
    public Arduino() {
        arduino = new SerialPort(115200, SerialPort.Port.kUSB);
    }
    public void send(String input){
        arduino.flush();
        arduino.writeString(input);
    }

    public void get(){
        String in = arduino.readString();
        arduino.flush();
        String split[] = in.split(" " , 0);
        //lidar = Integer.parseInt(split[0])
        //baby = Integer.parseInt(split[2]);
/*
        lidar = split[0];
        analog = split[1];
        baby = split[1];
        if (lidar == "30"){
            System.out.println("CLOSE");
        }
*/
        System.out.println(in);
        //System.out.println("hiii");
    }
}
