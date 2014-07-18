package subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;

/**
 *
 * @author matthew
 */
public class Blower extends Subsystem {
    
    public final DoubleSolenoid blowers;
    
    public Blower() {
        blowers = new DoubleSolenoid(HW.BLOWERS, HW.BLOWERS+1);
    }
    
    public void blow_out() {
        blowers.set(DoubleSolenoid.Value.kForward);
    }
    
    public void blow_in() {
        blowers.set(DoubleSolenoid.Value.kReverse);
    }

    protected void initDefaultCommand() {
    }

}
