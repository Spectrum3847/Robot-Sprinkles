package framework;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author matthew
 */
public class Teleop {
    
    public static boolean isPoleUp = false;
    
    public static void init() {
        Scheduler.getInstance().removeAll();
        Init.butteryflydrive.start();
    }

    public static void periodic() {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

    public static void cancel() {
        Scheduler.getInstance().removeAll();
    }
}
