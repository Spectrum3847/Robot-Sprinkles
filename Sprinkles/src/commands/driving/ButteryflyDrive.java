package commands.driving;

import commands.CommandBase;
import driver.Gamepad;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;
import framework.OI;
import framework.Utilities;


/*
 * @author Matthew
 */
public class ButteryflyDrive extends CommandBase {

    public ButteryflyDrive() {
        requires(CommandBase.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Butteryflydrive, GO!");
        drivebase.setCheesySensetivity(SmartDashboard.getNumber(Dashboard.BUTTERY_SENSITIVITY, 0.674));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double raw_throttle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double wheel = Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
        boolean quickturn = OI.gamepad.getButton(Gamepad.RIGHT_CLICK);

        double throttle = Utilities.expMap(raw_throttle);
        double quickTurnTriggers = OI.gamepad.getTriggers();

        if (quickTurnTriggers != 0) {
            wheel = -(quickTurnTriggers != 0 ? quickTurnTriggers : wheel);
            quickturn = true;
        }
        drivebase.setCheesyDrive(throttle, wheel, quickturn);
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
