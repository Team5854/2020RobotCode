package frc.robot;

public class Autoalign extends Robot{
    private static int cycleCounter = 0;
    public static void alignShot(){
        switch(cycleCounter){
            case 0:
                //move to wall w/ ramping of speed
                if(wallHit){

                }
                break;
            case 1:
                //contine driving into the wall to align and then zero the gyro
                break;
            case 2:
                //move back w/ ramping
                break;
            case 3:
                //turn left 90 degrees w/ ramping
                break;
            case 4:
                //move forwards and backwards with ramping 
                break;
            case 5:
                //set aligned to true, cycle counter back 
                break;
        }
    }
}