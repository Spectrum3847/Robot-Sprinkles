package subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import framework.Dashboard;
import framework.HW;

/**
 *
 * @author matthew
 */
public class SippingBird extends Subsystem {
    
    private final Victor leftMotor, rightMotor;
    
    public SippingBird() {
        leftMotor = new Victor(HW.COLLECTOR_LEFT);
        rightMotor = new Victor(HW.COLLECTOR_RIGHT);
    }
    
    protected void initDefaultCommand() {
    }
    
    public void setCollector(double v) {
        leftMotor.set(-v); // Invert for robot
        rightMotor.set(v);
    }

    public void collectorIN() {
        setCollector(SmartDashboard.getNumber(Dashboard.COLLECTOR_IN_SPEED, 0.6));
    }

    public void collectorOFF() {
        setCollector(0.0);
    }

    public void collectorOUT() {
        setCollector(SmartDashboard.getNumber(Dashboard.COLLECTOR_OUT_SPEED, -1.0));
    }
}
