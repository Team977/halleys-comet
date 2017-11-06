
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticPusher extends Subsystem {

	private Solenoid Pusher;
	
	public PneumaticPusher(){
		super();
		Pusher = new Solenoid(RobotMap.BoulderPusherPort);
	}
	
	public void Fire(){
		
		Pusher.set(true);
		
	}
	
	public void Reset(){
		Pusher.set(false);
	}
	
	
	
	public void DisabledReset(){
		Pusher.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

