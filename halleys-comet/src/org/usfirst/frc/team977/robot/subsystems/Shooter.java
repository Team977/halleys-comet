
package org.usfirst.frc.team977.robot.subsystems;

import org.usfirst.frc.team977.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	private SpeedController shooterMotor1;
	private SpeedController shooterMotor2;

	
	public Shooter(){
		super();
		shooterMotor1 = new Victor(RobotMap.ShooterMotorPWM1);
		shooterMotor2 = new Victor(RobotMap.ShooterMotorPWM2);

	}
	
	public void SetShooterSpeed(double speed){
		shooterMotor2.set(speed); //left
		shooterMotor1.set(speed); //right
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new StopShooters());
    }
}

