package frc.robot;

public class Autoalign extends Robot{
    private boolean activeAlign;
    private boolean alignedAngle = false;
    private boolean alignedDistance = false;
    private double aimAngle;
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
    private boolean firstRun = true;
    public int alignShot(boolean input){
        if(input){//checks state change
            activeAlign = !activeAlign;
            if(activeAlign){
                firstRun = true;
            }
            return 0;
        }
        if(activeAlign){//alignment in progress code
            if(firstRun){
                robotAngle = Math.atan((Lfof)/Lsep);
                aimAngle = Math.atan((((Usof)*Math.cos(robotAngle))-Gdis)/(((Lfof+Lfof)/2)*Math.cos(robotAngle)));
                alignedAngle = false;
                alignedDistance = false;
                firstRun = false;
            }
            if(!alignedAngle){
                robotAngle = Math.atan((Lfof)/Lsep);
                turnPID = ((turnpTerm*(aimAngle-robotAngle))*(turniTerm*acum)*(turndTerm*Math.pow((aimAngle-robotAngle), 2)));
                drivetrain.arcade(0,turnPID);
                if(aimAngle-robotAngle > -1 && aimAngle-robotAngle < 1){
                    alignedAngle = true;
                }
                return 1;
            }
            else if(!alignedDistance){
                robotDistance = (1);
                return 1;
            }
            else{
                activeAlign =  false;
                return 2;
            }
        }
        else{
            return 0;
        }
    }
}