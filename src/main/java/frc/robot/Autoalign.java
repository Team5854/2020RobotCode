package frc.robot;

public class Autoalign extends Robot{
    private static boolean aligning;
    private static boolean alignedAngle = false;
    private static boolean alignedDistance = false;
    private static double turnpTerm = 1;
    private static double turniTerm = 1;
    private static double turndTerm = 1;
    private static double turnPID;
    private static double robotAngle;
    private static double robotDistance;
    private static double movepTerm = 1;
    private static double moveiTerm = 1;
    private static double movedTerm = 1;
    private static double movePID;
    private static double acum;
    public static void alignShot(boolean input){
        aligning = 
        if(aligning){
            if(!alignedAngle){
                robotAngle = Math.atan((/*right lidar subtract left lidear divided by distance between them*/));\
             if(robotAngle <= 2 && robotAngle >= -2){
                 alignedAngle = true;
             }
             else{
                 acum += robotAngle;
                    turnPID = (robotAngle*turnpTerm)*(acum*turniTerm)*(Math.pow(robotAngle,2)*turndTerm);
                drivetrain.arcade(0,turnPID);
                }
            }
            else if(alignedDistance){
                robotDistance = /*average of both lidar*/;
                acum += robotDistance;
                movePID = (robotDistance*movepTerm)*(acum*moveiTerm)*(Math.pow(robotDistance,2)*movedTerm);
                drivetrain.aracde(movePID,0);
            }
        }
        else{

        }
    }
}