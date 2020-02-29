package frc.robot;

public class Autoalign extends Robot{
    private boolean activeAlign;
    private boolean alignedAngle = false;
    private boolean alignedDistance = false;
    private double turnpTerm = 1;
    private double turniTerm = 1;
    private double turndTerm = 1;
    private double turnPID;
    private double robotAngle;
    private double robotDistance;
    private double movepTerm = 1;
    private double moveiTerm = 1;
    private double movedTerm = 1;
    private double movePID;
    private double acum;
    private double Lfof = 1;
    private double Lsep = 1;
    private double Usof = 1;
    private double Gdis = 1;
    public void alignShot(boolean input){
        if(input){activeAlign = !activeAlign;if(activeAlign){alignedAngle = false;alignedDistance = false;}}
        if(activeAlign){
            if(!alignedAngle){
                robotAngle = Math.atan((Lfof-Lfof)/Lsep);
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
                robotDistance = ((Lfof-Lfof)/Lsep);
                acum += robotDistance;
                movePID = (robotDistance*movepTerm)*(acum*moveiTerm)*(Math.pow(robotDistance,2)*movedTerm);
                drivetrain.arcade(movePID,0);
            }
        }
        else{

        }
    }
}