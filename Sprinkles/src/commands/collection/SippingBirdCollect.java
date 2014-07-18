package commands.collection;

import commands.CommandBase;


/*
 * @author Matthew
 */
public class SippingBirdCollect extends CommandBase {

    double speed = 0;
    
    public SippingBirdCollect() {
    }
    
    public SippingBirdCollect(double speed) {
        requires(CommandBase.sippingbird);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("SippingBird, GO!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(speed == 0)
            sippingbird.collectorIN();
        else
            sippingbird.setCollector(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        sippingbird.collectorOFF();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
