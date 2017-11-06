
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticGrip extends Subsystem {
    
	
	
	private Solenoid Grasper;
	
	public PneumaticGrip(){
		super();

		Grasper = new Solenoid(RobotMap.ArmGraspPort);
	}
	
	
	
	public void grab(){
		Grasper.set(true);
	}
	
	public void release(){
		Grasper.set(false);
	}
	
	public void DisabledReset(){
		Grasper.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

