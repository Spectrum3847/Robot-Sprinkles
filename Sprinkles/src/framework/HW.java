package framework;

/**
 * The HW is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    /**DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int REAR_RDRIVE_MOTOR = 9;
    public static final int FRONT_RDRIVE_MOTOR = 10;
    public static final int FRONT_RDRIVE_MOTOR_B = 7;
    public static final int FRONT_LDRIVE_MOTOR = 1;
    public static final int FRONT_LDRIVE_MOTOR_B = 4;
    public static final int REAR_LDRIVE_MOTOR = 2;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    
    public static final int COLLECTOR_RIGHT = 3;
    public static final int COLLECTOR_LEFT = 8;
    
    /**DIGITAL SENSOR ALLOCATIONS**/
    /**Pneumatics**/
    
    
    /**ANALOG SENSOR ALLOCATIONS**/ 
    
    /**RELAY ALLOCATIONS**/
   
    /**SOLENOID ALLOCATIONS**/
    public static final int BLOWERS = 1;
    
    
    /**PID CONSTANTS**/
    
    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int usbPort_one = 1;
    public static final int usbPort_two = 2;
}
