package commands.blowing;

import commands.CommandBase;

/**
 *
 * @author matthew
 */
public class Blow extends CommandBase {

    protected void initialize() {
        blower.blow_out();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        blower.blow_in();
    }

    protected void interrupted() {
        end();
    }

}
