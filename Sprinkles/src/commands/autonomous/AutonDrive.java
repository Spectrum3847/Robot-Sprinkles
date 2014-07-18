package commands.autonomous;

import commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;

/**
 * Drive forward until canceled
 * @author matthew
 */
public class AutonDrive extends CommandBase {

    private final double speed;
    private final String key;
    private double inverse = 1;
    
    public AutonDrive() {
        requires(CommandBase.drivebase);
        speed = 0.0;
        key = Dashboard.AUTON_SINGLE_LOW_DRIVE_FORWARD_SPEED;
    }
    
    public AutonDrive(double speed) {
        requires(CommandBase.drivebase);
        this.speed = speed;
        key = Dashboard.AUTON_SINGLE_LOW_DRIVE_FORWARD_SPEED;
    }
    
    public AutonDrive(String key) {
        requires(CommandBase.drivebase);
        speed = 0.0;
        this.key = key;
    }
    
    public AutonDrive(String key, boolean invert) {
        requires(CommandBase.drivebase);
        speed = 0.0;
        this.key = key;
        inverse = invert?-1:1;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivebase.setCheesySensetivity(1.32);
        if(speed != 0.0)
            drivebase.setCheesyDrive(-speed, 0, false);
        else
            drivebase.setCheesyDrive(-inverse*SmartDashboard.getNumber(key), 0, false);
        
        drivebase.getVictor(4).set(drivebase.getVictor(0).get());
        drivebase.getVictor(5).set(drivebase.getVictor(2).get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivebase.setArcade(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}