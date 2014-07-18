package framework;

import commands.CommandBase;
import commands.collection.SippingBirdCollect;
import commands.collection.SippingBirdEject;
import commands.collection.SippingBirdKiss;
import commands.driving.ButteryflyDrive;
/**
 *
 * @author matthew
 */
public class Init {

    public static ButteryflyDrive butteryflydrive = new ButteryflyDrive();
    
    public static SippingBirdCollect sippingbirdcollect = new SippingBirdCollect();
    public static SippingBirdEject sippingbirdeject = new SippingBirdEject();
    public static SippingBirdKiss sippingbirdkiss = new SippingBirdKiss();

    public static void init() {
        CommandBase.init();

        Dashboard.intializeDashboard();
    }

    public static void periodic() {
    }
}
