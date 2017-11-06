
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticLifter extends Subsystem {
    
	private Solenoid Lifter;
	
	public PneumaticLifter(){
		super();
		Lifter = new Solenoid(RobotMap.ShooterLifter);
	}
	
	public void RaiseShooter(){
		Lifter.set(true);
	}
	
	public void LowerShooter(){
		Lifter.set(false);
	}
	

	
	public void DisabledReset(){
		Lifter.set(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

