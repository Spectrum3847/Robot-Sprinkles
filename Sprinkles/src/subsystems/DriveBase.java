package subsystems;

import driver.SpectrumDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import framework.HW;
import framework.Init;

/**
 *
 * @author David, Matthew
 */
public class DriveBase extends Subsystem{

    //Drive Motor Controller
    private Victor vic_1, vic_2, vic_3, vic_4, vic_5, vic_6;
    private Victor[] vic_arr;
    private final SpectrumDrive spectrumDrive;

    public DriveBase() {
        super();
        setVictors();
        spectrumDrive = new SpectrumDrive(vic_1, vic_2, vic_3, vic_4);
    }

    /**
     * Set the Default Command Sets it to driveSelector so that we always have
     * the correct drive mode re-enabled after breaking or turning.
     */
    public void initDefaultCommand() {
        this.setDefaultCommand(Init.butteryflydrive);
    }

    public void setArcade(double straight_speed, double turn_speed) {
        spectrumDrive.arcadeDrive(straight_speed, turn_speed, true);
    }

    public void setCheesyDrive(double throttle, double wheel, boolean quickTurn) {
        spectrumDrive.Cheesydrive(throttle, -1 * wheel, quickTurn);
    }

    public void setCheesySensetivity(double sensetivity) {
        spectrumDrive.setSensitivity(sensetivity);
    }

    private void setVictors() {
        vic_arr = new Victor[6];
        vic_1 = new Victor(HW.FRONT_RDRIVE_MOTOR);
        vic_arr[0] = vic_1;
        vic_2 = new Victor(HW.REAR_RDRIVE_MOTOR);
        vic_arr[1] = vic_2;
        vic_3 = new Victor(HW.FRONT_LDRIVE_MOTOR);
        vic_arr[2] = vic_3;
        vic_4 = new Victor(HW.REAR_LDRIVE_MOTOR);
        vic_arr[3] = vic_4;
        
        vic_5 = new Victor(HW.FRONT_RDRIVE_MOTOR_B);
        vic_arr[4] = vic_5;
        vic_6 = new Victor(HW.FRONT_LDRIVE_MOTOR_B);
        vic_arr[5] = vic_6;
    }

    /*
     * END INIT COMMANDS
     */
    public Victor getVictor(int id) {
        return vic_arr[id];
    }

    public Victor[] getVicArr() {
        return vic_arr;
    }

    public SpectrumDrive getDrive() {
        return spectrumDrive;
    }
}
